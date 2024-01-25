package renato.com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import renato.com.example.demo.model.Client;

import java.util.List;

public interface ClientService {

    public List<Client> pegarClientes();

    public Client criar(Client client);

    //public ResponseEntity<?> updateClient(String id, Client client);

    public List<Client> findClientByName(String name);



    //Page<Client> listaClientes(Pageable pageable);
}
