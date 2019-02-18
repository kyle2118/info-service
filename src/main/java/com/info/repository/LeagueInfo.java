package com.info.repository;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
@EqualsAndHashCode
public class LeagueInfo {
    private String name;
    private String country;
    private String continent;

    private LeagueInfo(String name, String country, String continent) {
        this.name = name;
        this.country = country;
        this.continent = continent;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String country;
        private String continent;

        private Builder() {
        }

        public Builder withName(String name) {
            checkArgument(name != null, "League Name must not be null");
            this.name = name;
            return this;
        }

        public Builder from(String country) {
            checkArgument(country != null, "Club must represent a country");
            this.country = country;
            return this;
        }

        public Builder in(String continent) {
            checkArgument(continent != null, "Club must be in a continent");
            this.continent = continent;
            return this;
        }

        public LeagueInfo build() {
            return new LeagueInfo(name, country, continent);
        }

    }

}
