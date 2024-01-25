package renato.com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document
@Data
public class Client {

    @Id
    private String codigo;
    private String documentClient;
    private String fullNameClient;
    private LocalDateTime birthdate;
    private String contactPhone;



}
