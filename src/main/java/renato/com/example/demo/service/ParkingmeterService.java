package renato.com.example.demo.service;

import org.springframework.http.ResponseEntity;
import renato.com.example.demo.model.Parkimeter;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingmeterService {

    public List<Parkimeter> mostrarTodasAsVagas();

    public Parkimeter addVaga(Parkimeter parkimeter);

    public Parkimeter changeStatusWhenClientPark();

    public List<Parkimeter> adicionarPeriodo(String id);

    public Parkimeter comprarTempo(Parkimeter parkimeter);
    public List<Parkimeter> findParkByDate(LocalDateTime initialTime, LocalDateTime finalTime );




}
