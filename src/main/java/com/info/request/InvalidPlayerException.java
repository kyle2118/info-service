package com.info.request;

import lombok.Getter;

@Getter
public class InvalidPlayerException extends Exception {
    private String message;

    public InvalidPlayerException(String message) {
        this.message = message;
    }
}
