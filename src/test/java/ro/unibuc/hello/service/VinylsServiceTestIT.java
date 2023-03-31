package ro.unibuc.hello.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.VinylsEntity;
import ro.unibuc.hello.service.VinylsService;
import ro.unibuc.hello.controller.VinylsController;
import ro.unibuc.hello.data.VinylsRepository;

@SpringBootTest
@Tag("IT")
class VinylsServiceTestIT {

    @Autowired
    VinylsRepository vinylsRepository;

    @Autowired
    VinylsService vinylsService;

    @Test
    void testSaveVinyls() {
        // Arrange
        String title = "Vinyl Save";
        String artist = "Artist Save";
        int year = 1989;
        int price = 20;
        int id = 222;

        VinylsEntity VinylsEntityTest = new VinylsEntity(id, title, artist, year, price);
        

        // Act
        VinylsEntity savedVinyls = vinylsService.createVinyls(VinylsEntityTest);

        // Assert
        Assertions.assertEquals(title, savedVinyls.getTitle());
        Assertions.assertEquals(artist, savedVinyls.getArtist());
        Assertions.assertEquals(year, savedVinyls.getYear());
        Assertions.assertEquals(price, savedVinyls.getPrice());
        Assertions.assertEquals(id, savedVinyls.getId());
    }

    
     @Test
    void testDeleteVinyls()  {
        // Arrange
        String title = "Vinyl Delete";
        String artist = "Artist Delete";
        int year = 1999;
        int price = 22;
        int id = 220;
        VinylsEntity vinylsEntityTest = new VinylsEntity(id, title, artist, year, price);
        VinylsEntity savedVinyls = vinylsService.createVinyls(vinylsEntityTest);
        int id2 = savedVinyls.getId();

        // Act
        vinylsService.deleteVinylsById(id2);
 
    }

    
}