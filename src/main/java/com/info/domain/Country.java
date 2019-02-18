package com.info.domain;

import com.info.util.Continent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Formattable;
import java.util.Formatter;

@Getter
@EqualsAndHashCode
public class Country implements Formattable {
    private String name;
    private Continent continent;
    @Setter
    private int points;

    private Country(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }

    public static Country of(String name, Continent continent) {
        return new Country(name, continent);
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%-25s %-15s", name, continent);
    }

    @Override
    public String toString() {
        return "Country{" + name + ", " + continent + ", " + points + '}';
    }
}
