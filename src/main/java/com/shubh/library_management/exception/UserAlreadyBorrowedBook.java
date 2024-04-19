package com.shubh.library_management.exception;

public class UserAlreadyBorrowedBook extends RuntimeException{
    public UserAlreadyBorrowedBook() {
    }

    public UserAlreadyBorrowedBook(String message) {
        super(message);
    }

    public UserAlreadyBorrowedBook(Throwable cause) {
        super(cause);
    }

    public UserAlreadyBorrowedBook(String message, Throwable cause) {
        super(message, cause);
    }
}
