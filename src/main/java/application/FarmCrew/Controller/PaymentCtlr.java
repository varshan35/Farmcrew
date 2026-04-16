package application.FarmCrew.Controller;

import application.FarmCrew.DTO.PaymentRequest;
import application.FarmCrew.Entity.Payment;
import application.FarmCrew.Service.PaymentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
//@RequestMapping("/payments")
public class PaymentCtlr
{
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest request) {
        try {
            Payment payment = paymentService.createPayment(
                    new ObjectId(request.getWorkId()),
                    new ObjectId(request.getFarmerId()),
                    new ObjectId(request.getLaborId()),
                    request.getAgentId() != null ? new ObjectId(request.getAgentId()) : null,
                    request.getAmount(),
                    request.getPaymentMethod(),
                    request.getFarmerUpiId(),
                    request.getLaborUpiId(),
                    request.getAgentUpiId(),
                    request.getTransactionId()
            );


            return ResponseEntity.status(HttpStatus.CREATED).body(payment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment failed");
        }
    }


}
