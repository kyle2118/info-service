package com.info.request;

public class InvalidLeagueException extends Exception {
    public InvalidLeagueException(String msg, Exception cause) {
        super(msg, cause);
    }
}
