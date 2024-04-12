package com.shubh.library_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.entity.User;
import com.shubh.library_management.service.BookService;
import com.shubh.library_management.service.BorrowedBookService;
import com.shubh.library_management.service.UserService;

@RestController
@RequestMapping("/borrowedbooks")
public class BorrowedBookController {
    private BorrowedBookService borrowedBookService;
    private BookService bookService;
    private UserService userService;

    public BorrowedBookController(BorrowedBookService borrowedBookService, BookService bookService,
            UserService userService) {
        this.borrowedBookService = borrowedBookService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<BorrowedBookDTO> borrowingBook(@RequestBody BorrowedBookDTO borrowedBookDTO){
        Book book = bookService.getBookbyId(borrowedBookDTO.getBookId());
        User user = userService.getUserById(borrowedBookDTO.getUserId());
        return new ResponseEntity<BorrowedBookDTO>(borrowedBookService.borrowingBook(borrowedBookDTO,book,user)
        ,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BorrowedBookDTO>> getAllBorrowedBooks(){
        return new ResponseEntity<List<BorrowedBookDTO>>(borrowedBookService.getAllBorrowedBooks()
        ,HttpStatus.OK);
    }
}
