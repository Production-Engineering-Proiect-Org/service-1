package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.unibuc.hello.data.VinylsEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface VinylsRepository extends MongoRepository<VinylsEntity, String> {
    VinylsEntity findByTitle(String title);
}