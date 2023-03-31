package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.VinylsEntity;
import ro.unibuc.hello.data.VinylsRepository;

import java.util.List;

@Service
public class VinylsService {
    
    @Autowired
    private VinylsRepository vinylRepository;
    
    public List<VinylsEntity> getAllVinyls() {
        return vinylRepository.findAll();
    }
    public VinylsEntity createVinyls(VinylsEntity vinyls) {
        if (vinyls == null) {
            throw new IllegalArgumentException("Vinyls cannot be null");
        }
        return vinylRepository.save(vinyls);
    }
    public void deleteVinylsById(int id) {
    }
}

