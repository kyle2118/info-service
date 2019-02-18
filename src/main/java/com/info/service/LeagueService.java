package com.info.service;

import com.info.domain.Club;
import com.info.domain.Country;
import com.info.domain.League;
import com.info.repository.ClubInfo;
import com.info.repository.LeagueInfo;
import org.springframework.stereotype.Service;

@Service
public class LeagueService {
    public void showTable(League league) {

    }

    public ClubInfo createClub(Club club) {
        League league = club.getLeague();
        Country country = league.getCountry();

        LeagueInfo leagueInfo = LeagueInfo.createBuilder()
                .withName(league.getName())
                .from(country.getName())
                .in(country.getContinent().name())
                .build();

        String clubName = club.getName();
        return ClubInfo.of(clubName, leagueInfo);
    }
}
