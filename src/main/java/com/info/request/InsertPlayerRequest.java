package com.info.request;

import lombok.Data;

@Data
public class InsertPlayerRequest {
    private String firstName;
    private String lastName;
    private String dob;
    private String country;
    private String club;
    private short scored;
    private String position;
    private byte shirtNumber;
    private String foot;
}
