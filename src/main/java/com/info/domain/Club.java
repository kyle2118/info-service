package com.info.domain;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Club {
    private java.lang.String name;
    private List<Player> squad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(name, club.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
