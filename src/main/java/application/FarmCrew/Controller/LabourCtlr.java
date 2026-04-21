package application.FarmCrew.Controller;

import application.FarmCrew.Entity.Farmer;
import application.FarmCrew.Entity.Labour;
import application.FarmCrew.Service.LabourService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/labours")
public class LabourCtlr {

    @Autowired
    private LabourService labourService;

    // Register labor
    @PostMapping("/register")
    public Labour registerLabour(@RequestParam String name,
                                 @RequestParam String pwd) {
        return labourService.registerLabour(name, pwd);
    }

    @GetMapping("/login")
    public ResponseEntity<Labor> login(@RequestParam String name,
                                        @RequestParam String pwd) {

        Farmer farmer = labourService.login(name, pwd);

        if (farmer != null) {
            return ResponseEntity.ok(Labour);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    // Get labor by id
    @GetMapping("/{id}")
    public ResponseEntity<Labour> getById(@PathVariable ObjectId id) {

        Optional<Labour> labour = labourService.getLabourById(id);

        return labour
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update labor
    @PutMapping("/{id}")
    public ResponseEntity<Labour> updateLabour(@PathVariable ObjectId id,
                                               @RequestBody Labour updatedData) {

        Optional<Labour> updated = labourService.updateLabour(id, updatedData);

        return updated
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete labor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ObjectId id) {
        labourService.deleteLabour(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}