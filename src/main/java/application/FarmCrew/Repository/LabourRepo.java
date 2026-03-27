package application.FarmCrew.Repository;

import application.FarmCrew.Entity.Labour;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LabourRepo extends MongoRepository<Labour, ObjectId> {
}
