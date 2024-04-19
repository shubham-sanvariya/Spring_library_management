package com.shubh.library_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.service.BorrowedBookService;

@RestController
@RequestMapping("/borrowedbooks")
public class BorrowedBookController {
    private BorrowedBookService borrowedBookService;

    public BorrowedBookController(BorrowedBookService borrowedBookService) {
        this.borrowedBookService = borrowedBookService;
    }

    @PostMapping
    public ResponseEntity<?> borrowingBook(@RequestBody BorrowedBookDTO borrowedBookDTO){
        return new ResponseEntity<BorrowedBookDTO>(
                    borrowedBookService.borrowingBook(borrowedBookDTO),
                    HttpStatus.CREATED);
    }

    @PutMapping("/{borrowedBookId}")
    public ResponseEntity<?> returningBook(@PathVariable Long borrowedBookId){
        try {
            return new ResponseEntity<BorrowedBookDTO>(borrowedBookService.returnBook(borrowedBookId),
            HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<BorrowedBookDTO>> getAllBorrowedBooks(){
        return new ResponseEntity<List<BorrowedBookDTO>>(borrowedBookService.getAllBorrowedBooks()
        ,HttpStatus.OK);
    }
}
