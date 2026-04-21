package application.FarmCrew.Service;

import application.FarmCrew.Entity.Agent;
import application.FarmCrew.Repository.AgentRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService
{
    @Autowired
    private AgentRepo agentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    //private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Agent registerAgent(Agent agent) {
        agent.setPwd(passwordEncoder.encode(agent.getPwd()));
        return agentRepo.save(agent);
    }

    public Agent updateCommissionRate(ObjectId agentId, double newRate) {
        Agent agent = agentRepo.findById(agentId).orElseThrow();
        agent.setCommissionRate(newRate);
        return agentRepo.save(agent);
    }

    public double getAgentEarnings(ObjectId agentId) {
        Agent agent = agentRepo.findById(agentId).orElseThrow();
        return agent.getTotalEarnings();
    }

    public List<Agent> getAllAgents() {
        return agentRepo.findAll();
    }

}
