package application.FarmCrew.Repository;

import application.FarmCrew.Entity.Farmer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FarmerRepo extends MongoRepository<Farmer, ObjectId>
{
    List<Farmer> findByName(String name);

}
