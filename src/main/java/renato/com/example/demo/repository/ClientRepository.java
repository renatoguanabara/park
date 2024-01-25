package renato.com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import renato.com.example.demo.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

    Page<Client> findAll(Pageable pageable);
}
