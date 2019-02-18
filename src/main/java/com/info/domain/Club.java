package com.info.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.Formatter;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Club implements Formattable {
    public static final int MAX_SQUAD_SIZE = 25;
    private String name;
    private List<Player> squad;
    private League league;

    private Club(String name, League league) {
        squad = new ArrayList<>(MAX_SQUAD_SIZE);
        this.name = name;
        this.league = league;
    }

    public static Club of(String clubName, League league) {
        return new Club(clubName, league);
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%-25s %-20s", this.name, this.league);
    }

    @Override
    public String toString() {
        return "Club{" + name + ", " + league + '}';
    }
}
