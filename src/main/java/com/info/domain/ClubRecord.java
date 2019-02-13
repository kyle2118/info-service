package com.info.domain;

import com.info.util.Position;
import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
public class ClubRecord {
    private String clubName;
    private Position position;
    private byte shirtNumber;
    private short goals;

    private ClubRecord(String clubName, Position position, byte shirtNumber, short goals) {
        this.shirtNumber = shirtNumber;
        this.clubName = clubName;
        this.position = position;
        this.goals = goals;
    }

    public static ClubRecord of(String clubName, Position position, byte shirtNumber, short goals) {
        checkArgument(0 < shirtNumber && shirtNumber < 100);
        checkArgument(goals >= 0);
        return new ClubRecord(clubName, position, shirtNumber, goals);
    }

}
