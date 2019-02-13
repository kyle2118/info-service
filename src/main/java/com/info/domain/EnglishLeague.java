package com.info.domain;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class EnglishLeague extends League {
    private static final int CLUB_NUMBER = 20;

    public EnglishLeague() {
        clubList = new ArrayList<>(CLUB_NUMBER);
    }

    @Override
    public boolean promote(Club club) {
        return clubList.add(club);
    }

    @Override
    public boolean relegate(Club club) {
        return clubList.remove(club);
    }
}
