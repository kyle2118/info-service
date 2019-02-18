package com.info.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.google.common.base.Preconditions.checkArgument;

@Document(collection = "infoservice")
@Getter
public class ClubInfo {
    @Id
    @Setter
    private String id;
    @Indexed
    private String name;
    private LeagueInfo leagueInfo;

    private ClubInfo(String name, LeagueInfo leagueInfo) {
        this.name = name;
        this.leagueInfo = leagueInfo;
    }

    public static ClubInfo of(String name, LeagueInfo leagueInfo) {
        checkArgument(name != null, "Name must not be empty!");
        return new ClubInfo(name, leagueInfo);
    }
}
