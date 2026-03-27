package application.FarmCrew.Repository;
import application.FarmCrew.Entity.Work;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkRepo extends MongoRepository<Work, ObjectId> {

}
