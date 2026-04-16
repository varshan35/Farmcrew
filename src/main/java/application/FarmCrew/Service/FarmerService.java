package application.FarmCrew.Service;
import application.FarmCrew.Entity.Farmer;
import org.springframework.beans.factory.annotation.Autowired;
import application.FarmCrew.Repository.FarmerRepo;
import org.bson.types.ObjectId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FarmerService
{
    @Autowired
    private FarmerRepo farmerRepo;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Farmer registerFarmer(String name, String pwd) {
        Farmer farmer = new Farmer();
        farmer.setName(name);

        // hashing before saving pwd
        farmer.setPwd(passwordEncoder.encode(pwd));

        return farmerRepo.save(farmer);
    }

    public boolean login(String name, String rawPassword) {
        Farmer farmer = farmerRepo.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Farmer not found"));
        return passwordEncoder.matches(rawPassword, farmer.getPwd());
    }

    public Optional<Farmer> getFarmerById(ObjectId id)
    {
        return farmerRepo.findById(id);
    }

    public Optional<Farmer> updateFarmer(ObjectId id, Farmer updatedData)
    {
        Optional<Farmer> existingOpt = farmerRepo.findById(id);
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
            Farmer saved = farmerRepo.save(existing);
            return Optional.of(saved);
        }
        return Optional.empty();
    }

    public List<Farmer> getAllFarmers()
    {
        return farmerRepo.findAll();
    }

    public void deleteFarmer(ObjectId id)
    {
        farmerRepo.deleteById(id);
    }
}
