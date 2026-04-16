package application.FarmCrew.Service;
import application.FarmCrew.Entity.Labour;
import application.FarmCrew.Repository.LabourRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LabourService
{
    @Autowired
    private LabourRepo labourRepo;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Labour registerLabour(String name, String pwd)
    {
        Labour labour = new Labour();
        labour.setName(name);
        // hash the password before saving
        labour.setPwd(passwordEncoder.encode(pwd));
        labour.setPwd(pwd);
        return labourRepo.save(labour);
    }

    public Optional<Labour> getLabourById(ObjectId id)
    {
        return labourRepo.findById(id);
    }

    public Optional<Labour> updateLabour(ObjectId id, Labour updatedData)
    {
        Optional<Labour> existingOpt = labourRepo.findById(id);
        if (existingOpt.isPresent())
        {
            Labour existing = existingOpt.get();
            existing.setName(updatedData.getName());
            existing.setPwd(updatedData.getPwd());
            existing.setRole(updatedData.getRole());
            existing.setAge(updatedData.getAge());
            existing.setContact(updatedData.getContact());
            existing.setPlace(updatedData.getPlace());
            existing.setPan(updatedData.getPan());
            existing.setAadhar(updatedData.getAadhar());
            existing.setGender(updatedData.getGender());
            Labour saved = labourRepo.save(existing);
            return Optional.of(saved);
        }
        return Optional.empty();
    }

    public void deleteLabour(ObjectId id)
    {
        labourRepo.deleteById(id);
    }
}
