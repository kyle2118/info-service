package com.info.domain;

import java.util.ArrayList;

public class SpanishLeague extends League {

    private final static byte CLUB_NUMBER = 20;

    public SpanishLeague() {
        clubList = new ArrayList<>(CLUB_NUMBER);
    }

    @Override
    public boolean relegate(Club club) {
        return clubList.add(club);
    }

    @Override
    public boolean promote(Club club) {
        return clubList.remove(club);
    }
}
