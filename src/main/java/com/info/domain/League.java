package com.info.domain;

import java.util.Collections;
import java.util.List;

public abstract class League {
    protected String name;
    protected String country;
    protected List<Club> clubList;

    public abstract boolean relegate(Club club);
    public abstract boolean promote(Club club);
    public List<Club> getClubList() {
        return Collections.unmodifiableList(clubList);
    }

}
