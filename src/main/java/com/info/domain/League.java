package com.info.domain;

import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Getter
public class League {
    protected String name;
    protected Country country;
    protected LinkedList<Club> clubList;

    private League(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public static League of(@NonNull String name, @NotNull Country country) {
        return new League(name, country);
    }


    public boolean relegate(Club club) {
        System.err.println("Implement relegate");
        return false;
    }

    public boolean promote(Club club) {
        System.err.println("Implement promote");
        return false;
    }

    public List<Club> getClubList() {
        return Collections.unmodifiableList(clubList);
    }

}
