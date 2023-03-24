package ro.unibuc.hello.controller;

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

import ro.unibuc.hello.data.VinylsEntity;
import ro.unibuc.hello.service.VinylsService;

@ExtendWith(SpringExtension.class)
class VinylsControllerTest {

    @Mock
    private VinylsService vinylsService;

    @InjectMocks
    private VinylsController vinylsController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(vinylsController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void test_vinyls() throws Exception {
        // Arrange
        List<VinylsEntity> vinyls = new ArrayList<VinylsEntity>();
        vinyls.add(new VinylsEntity(1,"Wizard and Witch","Jarry Laster",1989,30.23));
        vinyls.add(new VinylsEntity(2,"One time only", "John Smith", 2000, 23));
        when(vinylsService.getAllVinyls()).thenReturn(vinyls);

        // Act
        MvcResult result = mockMvc.perform(get("/vinyls?list")
                .content(objectMapper.writeValueAsString(vinyls))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(vinyls));
    }
}