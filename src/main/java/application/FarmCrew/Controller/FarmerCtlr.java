package application.FarmCrew.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import application.FarmCrew.Entity.Farmer;
import application.FarmCrew.Repository.FarmerRepo;
import application.FarmCrew.Service.FarmerService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
//@RequestMapping("/api/farmers")
public class FarmerCtlr {

    @Autowired
    private  FarmerRepo farmerRepository;
    @Autowired
   private FarmerService farmerService;

//to register the farmer
    @PostMapping("/register")
    public Farmer registerFarmer(@RequestParam String name, @RequestParam String pwd)
    {
        return farmerService.registerFarmer(name, pwd);
    }//test done

    //to update farmer profile
    @PutMapping("/update/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable ObjectId id, @RequestBody Farmer updatedData)
    {
        Optional<Farmer> updated = farmerService.updateFarmer(id, updatedData);
        return updated .map(farmer -> new ResponseEntity<>(farmer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }//test done

    //get farmer by id
@GetMapping("/getById/{id}")
    public ResponseEntity<Farmer> getById(@PathVariable ObjectId id)
    {
        Optional<Farmer> farmer = farmerService.getFarmerById(id);
        return farmer .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }//test done

    //delete farmer by id
    @DeleteMapping("/deleteById/{id}") public ResponseEntity<Void> delete(@PathVariable ObjectId id)
    {
        farmerService.deleteFarmer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }//test done
}
