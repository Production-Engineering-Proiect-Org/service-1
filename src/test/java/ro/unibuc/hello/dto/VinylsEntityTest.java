package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ro.unibuc.hello.data.VinylsEntity;

class VinylsEntityTest {

  VinylsEntity myVinylsEntity = new VinylsEntity(1,"Wizard and Witch","Jarry Laster",1989,30.23);
  
    @Test
    void test_title(){
        Assertions.assertSame("Wizard and Witch", myVinylsEntity.getTitle());
    }
    @Test
    void test_artist(){
        Assertions.assertSame("Jarry Laster", myVinylsEntity.getArtist());
    }
    @Test
    void test_year(){
        Assertions.assertEquals(1989, myVinylsEntity.getYear());
    }
    @Test
    void test_price(){
        Assertions.assertEquals(30.23, myVinylsEntity.getPrice());
    }
    @Test
    void test_id(){
        Assertions.assertEquals(1, myVinylsEntity.getId());
    }

}