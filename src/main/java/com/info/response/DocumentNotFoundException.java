package com.info.response;

import lombok.Data;

@Data
public class DocumentNotFoundException extends Exception {
    private String message;

    public DocumentNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public DocumentNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
