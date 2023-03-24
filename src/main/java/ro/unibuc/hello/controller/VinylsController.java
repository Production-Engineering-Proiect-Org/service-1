package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.VinylsService;
import ro.unibuc.hello.data.VinylsEntity;

@RestController
public class VinylsController {
    @Autowired
    private VinylsService vinylsService;

    @GetMapping("/vinyls")
    public List<VinylsEntity> artist() throws EntityNotFoundException {
        return vinylsService.getAllVinyls();
    }
}