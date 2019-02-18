package com.info.request;

import lombok.Getter;

@Getter
public class InvalidClubException extends Exception {
    private String message;

    public InvalidClubException(String message) {
        this.message = message;
    }
}
