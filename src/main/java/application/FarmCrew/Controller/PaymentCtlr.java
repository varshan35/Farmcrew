package application.FarmCrew.Controller;

import application.FarmCrew.DTO.PaymentRequest;
import application.FarmCrew.Entity.Payment;
import application.FarmCrew.Service.PaymentService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/payments")
public class PaymentCtlr
{
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment createPayment(@Valid @RequestBody PaymentRequest request) {
        return paymentService.createPayment(request);
    }

}
