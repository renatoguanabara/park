package renato.com.example.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import renato.com.example.demo.model.Parkimeter;
import renato.com.example.demo.repository.ParkingmeterRepository;
import renato.com.example.demo.service.ParkingmeterService;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Component
@Slf4j
public class ParkingmeterServiceImpl implements ParkingmeterService {


    private MongoTemplate mongoTemplate;

    public ParkingmeterServiceImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    ParkingmeterRepository parkingmeterRepository;
    @Override
    public List<Parkimeter> mostrarTodasAsVagas() {
        return this.parkingmeterRepository.findAll();
    }

    @Override
    public Parkimeter addVaga(Parkimeter parkimeter) {
        return this.parkingmeterRepository.save(parkimeter);
    }

    @Override
    public Parkimeter changeStatusWhenClientPark() {
        return null;
    }


    @Override
    public List<Parkimeter> adicionarPeriodo(String id) {
        List<Parkimeter> allParkimeter = parkingmeterRepository.findAll();

        return allParkimeter.stream()
                .filter(parkimeter -> parkimeter
                        .getCodigo()
                        .equals(id))
                .collect(Collectors
                        .toList());

    }


    @Override
    public Parkimeter comprarTempo(Parkimeter parkimeter) {
        LocalDateTime currentTime = LocalDateTime.now();


            try {
                parkimeter.setHourStartedPark(currentTime);
                parkimeter.setPreviewFinishedPark(currentTime.plusMinutes(parkimeter.getTotalMinutes()));
                parkimeter.setTotalValue(parkimeter.getMinuteValue() * parkimeter.getTotalMinutes());
                parkingmeterRepository.save(parkimeter);


            } catch (Exception e) {

                throw new RuntimeException("Erro comprar tempo: " + e.getMessage());

            }
            return null;

    }

    @Override
    public List<Parkimeter> findParkByDate(LocalDateTime initialTime, LocalDateTime finalTime) {



    return null;


        /*return allPark.stream()   filter(parkimeter -> parkimeter.getHourStartedPark().

                (initialTime, finalTime));

        LocalDateTime inicioPeriodo = LocalDateTime.now().minusDays(7);
        LocalDateTime fimPeriodo = LocalDateTime.now();

        // Filtrar registros com base no período de tempo
        List<Registro> registrosFiltrados = registros.stream()
                .filter(registro -> estaDentroDoPeriodo(registro.getTimestamp(), inicioPeriodo, fimPeriodo))
                .collect(Collectors.toList());

        private static boolean estaDentroDoPeriodo(LocalDateTime dateTime, LocalDateTime inicio, LocalDateTime fim) {
            return !dateTime.isBefore(inicio) && !dateTime.isAfter(fim);*/

    }

}
