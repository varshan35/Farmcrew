package application.FarmCrew.Service;
import application.FarmCrew.Entity.Farmer;
import org.springframework.beans.factory.annotation.Autowired;
import application.FarmCrew.Repository.FarmerRepo;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FarmerService
{
    @Autowired
    private FarmerRepo farmerRepository;

    public Farmer registerFarmer(String name, String pwd)
    {
        Farmer farmer = new Farmer();
        farmer.setName(name);
        farmer.setPwd(pwd);
        return farmerRepository.save(farmer);
    }

    public Optional<Farmer> getFarmerById(ObjectId id)
    {
        return farmerRepository.findById(id);
    }

    public Optional<Farmer> updateFarmer(ObjectId id, Farmer updatedData)
    {
        Optional<Farmer> existingOpt = farmerRepository.findById(id);
        if (existingOpt.isPresent())
        {
            Farmer existing = existingOpt.get();
            existing.setName(updatedData.getName());
            existing.setPwd(updatedData.getPwd());
            existing.setRole(updatedData.getRole());
            existing.setAge(updatedData.getAge());
            existing.setContact(updatedData.getContact());
            existing.setAddress(updatedData.getAddress());
            existing.setPan(updatedData.getPan());
            existing.setAadhar(updatedData.getAadhar());
            existing.setGender(updatedData.getGender());
            Farmer saved = farmerRepository.save(existing);
            return Optional.of(saved);
        }
        return Optional.empty();
    }

    public List<Farmer> getAllFarmers()
    {
        return farmerRepository.findAll();
    }

    public void deleteFarmer(ObjectId id)
    {
        farmerRepository.deleteById(id);
    }
}
