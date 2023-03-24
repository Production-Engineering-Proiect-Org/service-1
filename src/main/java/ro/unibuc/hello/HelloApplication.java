package ro.unibuc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import ro.unibuc.hello.data.VinylsRepository;
import ro.unibuc.hello.data.VinylsEntity;
import ro.unibuc.hello.data.InformationEntity;
import ro.unibuc.hello.data.InformationRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "ro.unibuc.hello.data")
public class HelloApplication {

	@Autowired
	private InformationRepository informationRepository;
    @Autowired
    private VinylsRepository vinylsRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@PostConstruct
	public void runAfterObjectCreated() {
		informationRepository.deleteAll();
		informationRepository.save(new InformationEntity("Overview",
				"This is an example of using a data storage engine running separately from our applications server"));
		
		vinylsRepository.deleteAll();
		vinylsRepository.save(new VinylsEntity(1,"One time only", "John Smith", 2000, 23));
		vinylsRepository.save(new VinylsEntity(2,"Wizard and Witch","Jarry Laster",1989,30));
		vinylsRepository.save(new VinylsEntity(3,"Yolo Songs","Anna Fraid",2001,40));
	}
	
}