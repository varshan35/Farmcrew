package application.FarmCrew.Controller;

import application.FarmCrew.Entity.Agent;
import application.FarmCrew.Service.AgentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/agents")
public class AgentCtlr
{
    @Autowired
    private AgentService agentService;

    @PostMapping("/saveAgent")
    public ResponseEntity<?> registerAgent(@RequestBody Agent agent) {
        try {
            Agent saved = agentService.registerAgent(agent);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved); // 201
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Agent registration failed"); // 500
        }
    }

    @GetMapping("/{id}/earnings")
    public ResponseEntity<?> getAgentEarnings(@PathVariable ObjectId id) {
        try {
            double earnings = agentService.getAgentEarnings(id);
            return ResponseEntity.ok(earnings); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agent not found"); // 404
        }
    }

    @GetMapping("/getAllAgents")
    public ResponseEntity<List<Agent>> getAllAgents() {
        return ResponseEntity.ok(agentService.getAllAgents()); // 200 OK
    }

}
