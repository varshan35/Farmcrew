package application.FarmCrew.Controller;

import application.FarmCrew.Entity.Farmer;
import application.FarmCrew.Entity.Labour;
import application.FarmCrew.Repository.LabourRepo;
import application.FarmCrew.Service.LabourService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class LabourCtlr
{
    @Autowired
    private LabourRepo labourRepo;

    @Autowired
    private LabourService labourService;
    //to register labour
    @PostMapping("/registerLabour")
    public Labour registerLabour(@RequestParam  String name, @RequestParam String pwd)
    {
        return labourService.registerLabour(name, pwd);
    }

    //to get labour by id
    @GetMapping("/getBLabourById/{id}")
    public ResponseEntity<Labour> getById(@PathVariable ObjectId id)
    {
        Optional<Labour> labour = labourService.getLabourById(id);
        return labour .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //to update labour
    @PutMapping("/updateLabour/{id}")
    public ResponseEntity<Labour> updateLabour(@PathVariable ObjectId id, @RequestBody Labour updatedData)
    {
        Optional<Labour> updated = labourService.updateLabour(id, updatedData);
        return updated .map(labour -> new ResponseEntity<>(labour, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //to delete labour by id
    @DeleteMapping("/deleteLabourById/{id}") public ResponseEntity<Void> delete(@PathVariable ObjectId id)
    {
        labourService.deleteLabour(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

