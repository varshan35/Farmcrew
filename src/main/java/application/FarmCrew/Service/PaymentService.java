package application.FarmCrew.Service;

import application.FarmCrew.Entity.*;
import application.FarmCrew.Repository.AgentRepo;
import application.FarmCrew.Repository.FarmerRepo;
import application.FarmCrew.Repository.PaymentRepo;
import application.FarmCrew.Repository.WorkRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService
{
    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private AgentRepo agentRepo;

    @Autowired
    private WorkRepo workRepo;

    @Autowired
    private FarmerRepo farmerRepo;

    public Payment createPayment(ObjectId workId,
                                 ObjectId farmerId,
                                 ObjectId laborId,
                                 ObjectId agentId,
                                 double amount,
                                 String paymentMethod,
                                 String farmerUpiId,
                                 String laborUpiId,
                                 String agentUpiId,
                                 String transactionId) {

        Payment payment = new Payment();
        payment.setWorkId(workId);
        payment.setFarmerId(farmerId);
        payment.setLaborId(laborId);
        payment.setAmount(amount);
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setTimestamp(LocalDateTime.now());

        // set method
        if ("UPI".equalsIgnoreCase(paymentMethod)) {
            payment.setPaymentMethod(PaymentMethod.UPI);
            payment.setFarmerUpiId(farmerUpiId);
            payment.setLaborUpiId(laborUpiId);
            if (agentId != null) {
                payment.setAgentUpiId(agentUpiId);
            }
            payment.setTransactionId("TXN-" + UUID.randomUUID().toString());
        } else {
            payment.setPaymentMethod(PaymentMethod.CASH);
        }


        if (agentId != null) {
            Agent agent = agentRepo.findById(agentId)
                    .orElseThrow(() -> new IllegalArgumentException("Agent not found"));

            double commission = amount * agent.getCommissionRate() / 100;
            payment.setAgentId(agentId);
            payment.setAgentCommission(commission);
            payment.setLaborNetAmount(amount - commission);
            agent.setTotalEarnings(agent.getTotalEarnings() + commission);
            agentRepo.save(agent);
        } else {
            payment.setLaborNetAmount(amount);
        }
            payment.setPaymentStatus(PaymentStatus.COMPLETED);
        Payment savedPayment = paymentRepo.save(payment);

        //Updating work status automatically
        Work work = workRepo.findById(workId)
                .orElseThrow(() -> new IllegalArgumentException("Work not found"));
        work.setWorkStatus(WorkStatus.COMPLETED);
        workRepo.save(work);

        return savedPayment;
    }
}
