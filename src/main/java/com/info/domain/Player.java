package com.info.domain;

import com.google.common.base.MoreObjects;
import com.info.util.Foot;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Formattable;
import java.util.Formatter;

@Getter
@Document
public class Player implements Formattable, Comparable<Player> {
    private static final Comparator<Player> PLAYER_COMPARATOR = Comparator
            .comparing((Player p) -> p.firstName)
            .thenComparing((p -> p.lastName));
    @Id
    private String id;
    @Indexed
    private String lastName;
    @Indexed
    private String firstName;
    @Indexed
    private String country;
    private LocalDate dob;
    private Foot foot;
    private ClubRecord clubRecord;

    private Player(String lastName, String firstName, ClubRecord clubRecord, String country, LocalDate dob, Foot foot) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.clubRecord = clubRecord;
        this.country = country;
        this.dob = dob;
        this.foot = foot;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .toString();
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%-20s%-20s", firstName, lastName);
    }

    @Override
    public int compareTo(Player o) {
        return PLAYER_COMPARATOR.compare(this, o);
    }

    private void setClubRecord(ClubRecord clubRecord) {
        this.clubRecord = clubRecord;
    }

    public static class PlayerBuilder {
        private String lastName;
        private String firstName;
        private String country;
        private LocalDate dob;
        private Foot foot;
        private ClubRecord clubRecord;

        public PlayerBuilder(@NotNull String firstName) {
            this.firstName = firstName;
        }

        public PlayerBuilder withLastName(@NotNull String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PlayerBuilder from(@NotNull String country) {
            this.country = country;
            return this;
        }

        public PlayerBuilder born(@NotNull LocalDate date) {
            this.dob = date;
            return this;
        }

        public PlayerBuilder foot(@NotNull Foot foot) {
            this.foot = foot;
            return this;
        }

        public PlayerBuilder withRecords(ClubRecord clubRecord) {
            this.clubRecord = clubRecord;
            return this;
        }

        public Player create() {
            return new Player(lastName, firstName, clubRecord, country, dob, foot);
        }
    }
}
