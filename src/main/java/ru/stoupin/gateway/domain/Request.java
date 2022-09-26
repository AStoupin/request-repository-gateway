package ru.stoupin.gateway.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "REQUEST")
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp created;
    private String requestServer;
    private String requestUrl;
    private String requestMethod;

}
