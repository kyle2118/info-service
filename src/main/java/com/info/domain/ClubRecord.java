package com.info.domain;

import com.info.util.Position;
import lombok.Getter;

import javax.validation.constraints.NotNull;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
public class ClubRecord {
    private Position position;
    private byte shirtNumber;
    private short goals;

    private ClubRecord(Position position, byte shirtNumber, short goals) {
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.goals = goals;
    }
    public static class Builder {
        private Position position;
        private byte shirtNumber;
        private short goals;

        public Builder atPosition(@NotNull Position position) {
            this.position = position;
            return this;
        }
        public Builder withShirtNumber(byte shirtNumber) {
            checkArgument(0 < shirtNumber && shirtNumber < 100);
            this.shirtNumber = shirtNumber;
            return this;
        }
        public Builder scored(short goals) {
            checkArgument(goals >= 0);
            this.goals = goals;
            return this;
        }
        public ClubRecord build() {
            return new ClubRecord(position, shirtNumber, goals);
        }
    }

}
