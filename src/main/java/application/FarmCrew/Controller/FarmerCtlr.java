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
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/farmers")
public class FarmerCtlr {

    @Autowired
    private FarmerService farmerService;

    // Register
    @PostMapping("/register")
    public Farmer registerFarmer(
            @RequestParam String name,
            @RequestParam String pwd) {
        return farmerService.registerFarmer(name, pwd);
    }

    @GetMapping("/login")
    public ResponseEntity<Farmer> login(@RequestParam String name,
                                        @RequestParam String pwd) {

        Farmer farmer = farmerService.login(name, pwd);

        if (farmer != null) {
            return ResponseEntity.ok(farmer);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Update by id
    @PutMapping("/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable ObjectId id,
                                               @RequestBody Farmer updatedData) {

        Optional<Farmer> updated = farmerService.updateFarmer(id, updatedData);

        return updated
                .map(f -> new ResponseEntity<>(f, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getById(@PathVariable ObjectId id) {

        return farmerService.getFarmerById(id)
                .map(f -> new ResponseEntity<>(f, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ObjectId id) {
        farmerService.deleteFarmer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}