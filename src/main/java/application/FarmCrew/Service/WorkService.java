package application.FarmCrew.Service;

import application.FarmCrew.Entity.Work;
import application.FarmCrew.Repository.FarmerRepo;
import application.FarmCrew.Repository.WorkRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkService {
    @Autowired
    private WorkRepo workRepository;

    @Autowired
    private FarmerRepo farmerRepository;

    public Work postWork(Work work)
    {
        return workRepository.save(work);
    }

    public void deleteWork(ObjectId id)
    {
        workRepository.deleteById(id);
    }

    public Work saveWorkForFarmer(ObjectId farmerId, Work work)
    {
        if (farmerRepository.existsById(farmerId))
        {
            work.setFarmerId(farmerId);
             return workRepository.save(work);
        } return null;
    }

    public Optional<Work> updateWork(ObjectId id,Work newData){
        Optional<Work> oldData = workRepository.findById(id);
        if (oldData.isPresent()){
            Work existing = oldData.get();
            existing.setDuration(newData.getDuration());
            existing.setTypeOfWork(newData.getTypeOfWork());
            existing.setPaymentStatus(newData.getPaymentStatus());
            existing.setWorkStatus(newData.getWorkStatus());
            Work saved = workRepository.save(existing);
            return Optional.of(saved);
        }
        return Optional.empty();
    }
}
