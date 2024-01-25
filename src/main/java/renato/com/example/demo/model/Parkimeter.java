package renato.com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
@Data
public class Parkimeter {

    @Id
    private  String codigo;
    private double minuteValue;
    private boolean parkingSpotAvaible;
    private LocalDateTime hourStartedPark;
    private LocalDateTime previewFinishedPark;
    private long totalMinutes;
    private double totalValue;
}
