package application.FarmCrew.Repository;

import application.FarmCrew.Entity.Labour;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LabourRepo extends MongoRepository<Labour, ObjectId> {
    Optional<Labour> findByName(String name);
}
