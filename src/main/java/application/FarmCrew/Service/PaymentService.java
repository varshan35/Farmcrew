package application.FarmCrew.Service;

import application.FarmCrew.DTO.PaymentRequest;
import application.FarmCrew.Entity.*;
import application.FarmCrew.Repository.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private AgentRepo agentRepo;

    @Autowired
    private WorkRepo workRepo;

    @Autowired
    private FarmerRepo farmerRepo;

    public Payment createPayment(PaymentRequest request) {

        if (request.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Payment payment = new Payment();

        ObjectId workId = new ObjectId(request.getWorkId());
        ObjectId farmerId = new ObjectId(request.getFarmerId());
        ObjectId laborId = new ObjectId(request.getLaborId());

        payment.setWorkId(workId);
        payment.setFarmerId(farmerId);
        payment.setLaborId(laborId);
        payment.setAmount(request.getAmount());
        payment.setTimestamp(LocalDateTime.now());
        payment.setPaymentStatus(PaymentStatus.PENDING);

        // Payment method
        if ("UPI".equalsIgnoreCase(request.getPaymentMethod())) {

            if (request.getFarmerUpiId() == null || request.getLaborUpiId() == null) {
                throw new IllegalArgumentException("UPI IDs required for UPI payment");
            }

            payment.setPaymentMethod(PaymentMethod.UPI);
            payment.setFarmerUpiId(request.getFarmerUpiId());
            payment.setLaborUpiId(request.getLaborUpiId());
            payment.setAgentUpiId(request.getAgentUpiId());

            payment.setTransactionId("TXN-" + UUID.randomUUID());

        } else {
            payment.setPaymentMethod(PaymentMethod.CASH);
        }

        // Agent logic
        if (request.getAgentId() != null) {

            ObjectId agentId = new ObjectId(request.getAgentId());

            Agent agent = agentRepo.findById(agentId)
                    .orElseThrow(() -> new IllegalArgumentException("Agent not found"));

            double commission = request.getAmount() * agent.getCommissionRate() / 100;

            payment.setAgentId(agentId);
            payment.setAgentCommission(commission);
            payment.setLaborNetAmount(request.getAmount() - commission);

            agent.setTotalEarnings(agent.getTotalEarnings() + commission);
            agentRepo.save(agent);

        } else {
            payment.setLaborNetAmount(request.getAmount());
        }

        payment.setPaymentStatus(PaymentStatus.COMPLETED);

        Payment savedPayment = paymentRepo.save(payment);

        // Update work
        Work work = workRepo.findById(workId)
                .orElseThrow(() -> new IllegalArgumentException("Work not found"));

        work.setWorkStatus(WorkStatus.COMPLETED);
        workRepo.save(work);

        return savedPayment;
    }
}