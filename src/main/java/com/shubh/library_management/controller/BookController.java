package com.shubh.library_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.library_management.dto.BookDTO;
import com.shubh.library_management.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> createNewBook(@RequestBody BookDTO bookDTO){
        return new ResponseEntity<BookDTO>(bookService.createBook(bookDTO),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return new ResponseEntity<List<BookDTO>>(bookService.getAllBooks(),HttpStatus.OK);
    }
}
