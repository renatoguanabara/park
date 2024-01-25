package renato.com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import renato.com.example.demo.model.Parkimeter;

public interface ParkingmeterRepository extends MongoRepository<Parkimeter, String> {

    Page<Parkimeter> findAll(Pageable pageable);
}
