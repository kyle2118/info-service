package com.info.repository;

import com.info.domain.League;

import javax.validation.constraints.NotNull;

public final class Converter {
    private Converter() {
    }

    public static LeagueInfo toLeagueInfo(@NotNull League league) {
        return LeagueInfo.of(league.getName(), league.getCountry().getName());
    }

}
