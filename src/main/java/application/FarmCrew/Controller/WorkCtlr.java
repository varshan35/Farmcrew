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
@CrossOrigin("*")
@RequestMapping("/works")
public class WorkCtlr {

    @Autowired
    private WorkService workService;

    // Create work
    @PostMapping("/{farmerId}")
    public ResponseEntity<Work> postWork(@RequestBody Work work,
                                         @PathVariable ObjectId farmerId) {

        Work saved = workService.saveWorkForFarmer(farmerId, work);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Delete work
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable ObjectId id) {
        workService.deleteWork(id);
        return ResponseEntity.noContent().build();
    }

    // Update work
    @PutMapping("/{id}")
    public ResponseEntity<Work> updateWork(@PathVariable ObjectId id,
                                           @RequestBody Work newData) {

        return workService.updateWork(id, newData)
                .map(w -> ResponseEntity.ok(w))
                .orElse(ResponseEntity.notFound().build());
    }
}