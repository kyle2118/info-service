package com.info.request;

import lombok.Getter;

@Getter
public class InvalidPlayerDataException extends Exception {
    private String message;

    public InvalidPlayerDataException(String message) {
        this.message = message;
    }
}
