package com.info.repository;

import com.info.domain.League;

import javax.validation.constraints.NotNull;

public final class Converter {
    private Converter() {
    }

    public static LeagueInfo toLeagueInfo(@NotNull League league) {
        return null;
//        return LeagueInfo
//                .createBuilder()
//                .withName(league.getName())
//                .from(league.getCountry())
//                .in(league.getName());
    }

}
