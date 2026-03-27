package application.FarmCrew.Controller;
import application.FarmCrew.Entity.Work;
import application.FarmCrew.Service.FarmerService;
import application.FarmCrew.Service.WorkService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("/api/works")
public class WorkCtlr
{
    @Autowired
    private WorkService workService;

    @Autowired
    private FarmerService farmerService;
    //to post work
    @PostMapping("/postWork/{id}")
    public ResponseEntity<Work> postWork(@RequestBody Work work,@PathVariable ObjectId id)
    {
        Work saved = workService.saveWorkForFarmer(id, work);
        if (saved == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        //return new ResponseEntity<>(HttpStatus.OK);
    }//test done
    //to delete work
    @DeleteMapping("deleteWork/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable ObjectId id)
    {
        workService.deleteWork(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }//test done

    //to edit work
    @PutMapping("/updateWork/{id}")
    public ResponseEntity<Work> updateWork(@PathVariable ObjectId id, @RequestBody Work newData)
    {
        Optional<Work> updated = workService.updateWork(id, newData);
        return updated .map(work -> new ResponseEntity<>(work, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /* @PutMapping("/Payment/{id}")
    public ResponseEntity<?> Payment(@RequestBody Work obj, @PathVariable Integer id)
    {
        var payment=workRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        payment.setPaymentStatus("Sent");
        workRepository.save(payment);
        return new ResponseEntity<>("Payment send successfully",HttpStatus.OK);
    }

    @PutMapping("/Updatepaymentdetails/{id}")
    public ResponseEntity<?> Updatepaymentdetails(@PathVariable Integer id)
    {
        var payment=workRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        payment.setPaymentstatus("Recieved");
        workRepository.save(payment);
        return new ResponseEntity<>("Payment Recieved successfully",HttpStatus.OK);
    }*/
}
