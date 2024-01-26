package renato.com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import renato.com.example.demo.model.Parkimeter;
import renato.com.example.demo.service.ParkingmeterService;

import java.time.LocalDateTime;
import java.util.List;





@RestController
@RequestMapping(value="/parkimeter")

public class ParkingmeterController {

    @Autowired
    ParkingmeterService parkingmeterService;


    @GetMapping
    public List<Parkimeter> mostaTodasAsVagas(){
        return this.parkingmeterService.mostrarTodasAsVagas();
    }



    @PostMapping
    public Parkimeter criaVaga(@RequestBody Parkimeter parkimeter){
        return this.parkingmeterService.addVaga(parkimeter);
    }




    @PostMapping("/horaa")
    public Parkimeter comprarTempo(@RequestBody Parkimeter parkimeter){
        return this.parkingmeterService.comprarTempo(parkimeter);
    }




    @GetMapping("/id")
    public List<Parkimeter> findParkimeterById(@RequestBody String id){
        return parkingmeterService.adicionarPeriodo(id);
    }



    @GetMapping("/timee")
    public List<Parkimeter> findParkByDate(@RequestParam LocalDateTime initialTime,@RequestParam LocalDateTime finalTime) {
        return parkingmeterService.findParkByDate(initialTime,finalTime);
    }
}
