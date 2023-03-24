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
}