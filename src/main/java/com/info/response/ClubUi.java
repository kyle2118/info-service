package com.info.response;

import lombok.Data;

@Data
public class ClubUi {
    private String name;
    private LeagueUi league;

    public ClubUi(String name, LeagueUi league) {
        this.name = name;
        this.league = league;
    }
}
