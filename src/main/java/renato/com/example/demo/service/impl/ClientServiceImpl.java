package renato.com.example.demo.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;



import renato.com.example.demo.model.Client;
import renato.com.example.demo.repository.ClientRepository;
import renato.com.example.demo.service.ClientService;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {


    private MongoTemplate mongoTemplate;

    public ClientServiceImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }


    @Autowired
    ClientRepository clientRepository;



    @Override
    public List<Client> pegarClientes() {
        return this.clientRepository.findAll();
    }



    @Override
    public Client criar(Client client) {
        return this.clientRepository.save(client);
    }

   /* @Override
    public ResponseEntity<?> updateClient(String id, Client client) {
        return null;
    }*/

    @Override
    public List<Client> findClientByName(String name) {

        List<Client> todosOsClientes = clientRepository.findAll();

        return todosOsClientes.stream()
                .filter(client -> client
                        .getFullNameClient()
                        .equals(name))
                .collect(Collectors
                        .toList());
    }





  /*  @Override
    public Page<Client> listaClientes(Pageable pageable) {
        Sort sort = Sort.by("fullNameClient").ascending();
        Pageable paginacao =
                PageRequest.of(pageable.getPageNumber(),
                        pageable.getPageSize(), sort);
        return this.clientRepository.findAll(paginacao);
    }*/
}
