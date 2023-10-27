package com.beatvote.app.core.base.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super();
    }

    BadRequestException(String message) {
        super(message);
    }

    BadRequestException(String message, Throwable e) {
        super(message, e);
    }
}
