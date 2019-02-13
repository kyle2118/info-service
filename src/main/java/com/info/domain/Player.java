package com.info.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.common.base.MoreObjects;
import com.info.util.Foot;
import com.info.util.Position;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Formattable;
import java.util.Formatter;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Getter
public class Player implements Formattable, Comparable<Player> {
    private static final Comparator<Player> PLAYER_COMPARATOR = Comparator
            .comparing((Player p) -> p.firstName)
            .thenComparing((p -> p.lastName));
    private String lastName;
    private String firstName;
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


    private void transferSupplier(Supplier<ClubRecord> supplier) {
        this.clubRecord = supplier.get();
    }

    private void setClubRecord(ClubRecord clubRecord) {
        this.clubRecord = clubRecord;
    }




    public static void main(String[] args) {
        Player player = new Player("Baktybek uulu", "Kyialbek", null, "Kyrgyzstan", null, Foot.R);
        ClubRecord clubRecord1 = ClubRecord.of("Ajax", Position.CMF, (byte)21, (short)34);
        ClubRecord clubRecord2 = ClubRecord.of("Barcelona", Position.CMF, (byte)21, (short)34);

        player.transferSupplier(() -> clubRecord1);
        player.transferSupplier(() -> clubRecord2);
        player.setClubRecord(clubRecord1);

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
