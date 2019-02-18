package com.info.request;

import com.info.domain.Club;
import com.info.domain.ClubRecord;
import com.info.domain.Player;
import com.info.util.Foot;
import com.info.util.Position;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.google.common.base.Preconditions.checkArgument;

@Component
public class Converter {
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
        ClubRecord clubRecord = new ClubRecord
                .Builder(null)
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
        checkArgument(StringUtils.isEmpty(clubName), "Club name must present");
        String league = request.getLeague();
        checkArgument(StringUtils.isEmpty(league), "League must present");
        return Club.of(clubName);
    }
}
