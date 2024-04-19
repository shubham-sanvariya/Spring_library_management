package com.shubh.library_management.exception;

public class BookNotAvailable extends RuntimeException{
    public BookNotAvailable() {
    }

    public BookNotAvailable(String message) {
        super(message);
    }

    public BookNotAvailable(Throwable cause) {
        super(cause);
    }

    public BookNotAvailable(String message, Throwable cause) {
        super(message, cause);
    }
}