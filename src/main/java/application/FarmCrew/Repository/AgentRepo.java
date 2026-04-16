package application.FarmCrew.Repository;

import application.FarmCrew.Entity.Agent;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgentRepo extends MongoRepository<Agent, ObjectId> {
}
