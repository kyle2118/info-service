package com.info.response;

import lombok.Data;

@Data
public class LeagueUi {
    private String name;
    private CountryUi country;

    public LeagueUi(String name, CountryUi country) {
        this.name = name;
        this.country = country;
    }
}
