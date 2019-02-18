package com.info.repository;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@EqualsAndHashCode
@Document(collection = "infoservice")
public class LeagueInfo {
    @Id
    @Setter
    private String id;
    private String name;
    private String country;

    private LeagueInfo(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public static LeagueInfo of(String name, String country) {
        return new LeagueInfo(name, country);
    }

}
