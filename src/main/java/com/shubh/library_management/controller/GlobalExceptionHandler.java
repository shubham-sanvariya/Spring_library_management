package com.shubh.library_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shubh.library_management.exception.BookNotAvailable;
import com.shubh.library_management.exception.UserAlreadyBorrowedBook;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BookNotAvailable.class)
    public ResponseEntity<String> handleBookNotFoundException(final BookNotAvailable ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyBorrowedBook.class)
    public ResponseEntity<String> handleUserAlreadyBorrwedBook(final UserAlreadyBorrowedBook ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
