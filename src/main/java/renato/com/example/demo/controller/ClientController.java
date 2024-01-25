package renato.com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import renato.com.example.demo.model.Client;
import renato.com.example.demo.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> pegarClientes(){
        return this.clientService.pegarClientes();
    }

    @GetMapping("/name")
    public List<Client> findClientByName(@RequestBody String name){
        return clientService.findClientByName(name);
    }


    @PostMapping
    public Client criar(@RequestBody Client client){
        return this.clientService.criar(client);
    }
}
