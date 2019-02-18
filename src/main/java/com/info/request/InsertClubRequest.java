package com.info.request;

import lombok.Data;

@Data
public class InsertClubRequest {
    private String clubName;
    private String league;
    private String leagueCountry;
    private String leagueContinent;
}
