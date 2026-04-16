package application.FarmCrew.Repository;

import application.FarmCrew.Entity.Payment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepo extends MongoRepository<Payment, ObjectId>
{

}
