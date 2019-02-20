package com.info.response;

import lombok.Data;

@Data
public class CountryUi {
    private String name;
    private String continent;

    public CountryUi(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
