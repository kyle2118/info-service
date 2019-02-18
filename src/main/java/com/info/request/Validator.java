package com.info.request;

import com.info.domain.Club;
import com.info.domain.ClubRecord;
import com.info.domain.Country;
import com.info.domain.League;
import com.info.domain.Player;
import com.info.util.Continent;
import com.info.util.Foot;
import com.info.util.Position;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.google.common.base.Preconditions.checkArgument;

@Component
public class Validator {
    private static final DateTimeFormatter DOB_FORMAT = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    public Player convertToPlayer(InsertPlayerRequest request) {
        String firstName = request.getFirstName();
        checkArgument(firstName != null && firstName.trim().length() > 0, "First name must not be null!");
        String lastName = request.getLastName();
        checkArgument(lastName != null && lastName.trim().length() > 0, "Last name must not be null!");
        String country = request.getCountry();
        checkArgument(country != null, "Country must not be null");
        LocalDate dob = LocalDate.parse(request.getDob(), DOB_FORMAT);
        Foot foot = Foot.valueOf(request.getFoot());
        Position position = Position.valueOf(request.getPosition());
//        Club club = request.getClub();
        ClubRecord clubRecord = new ClubRecord.Builder()
                .atPosition(position)
                .withShirtNumber(request.getShirtNumber())
                .scored(request.getScored()).build();

        return new Player
                .PlayerBuilder(firstName)
                .withLastName(lastName)
                .from(country)
                .foot(foot)
                .born(dob)
                .withRecords(clubRecord)
                .create();
    }

    public Club convertToClub(InsertClubRequest request) {
        String clubName = request.getClubName();
        checkArgument(!StringUtils.isEmpty(clubName), "Club name must present");

        String leagueName = request.getLeague();
        checkArgument(!StringUtils.isEmpty(leagueName), "League name must not be empty");

        Continent continent = Continent.valueOf(request.getLeagueContinent().toUpperCase());
        String countryName = request.getLeagueCountry();
        checkArgument(!StringUtils.isEmpty(countryName), "League must belong to a country");

        Country country = Country.of(countryName, continent);
        League league = League.of(leagueName, country);

        return Club.of(clubName, league);
    }

    public League convertToLeague(InsertLeagueRequest request) {
        String leagueName = request.getName();
        checkArgument(!StringUtils.isEmpty(leagueName), "League name must not be empty");
        Continent continent = Continent.valueOf(request.getContinent().toUpperCase());
        String countryName = request.getCountry();
        checkArgument(!StringUtils.isEmpty(countryName), "League must belong to a country");
        Country country = Country.of(countryName, continent);
        return League.of(leagueName, country);
    }
}
