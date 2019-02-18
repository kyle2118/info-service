package com.info.repository;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Player")
public class PlayerInfo {
    @Id
    private Integer id;

    private String firstName;
    private String lastName;
    private String country;
    private String club;
    private String position;
    private String foot;
    private LocalDateTime dob;

}
