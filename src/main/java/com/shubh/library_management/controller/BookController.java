package com.shubh.library_management.controller;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.library_management.dto.BookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.mapper.BookMapper;
import com.shubh.library_management.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(@Lazy BookService bookService) {
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

    @PutMapping("/update-book")
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO){
        try {
            Book book = bookService.getBookbyId(bookDTO.getBookId());
            int prevBookCount = bookDTO.getTotalBookCount() - book.getTotalBookCount();
            bookDTO.setBookCount(prevBookCount + book.getBookCount());
            Book updatedBook = BookMapper.mapToBook(bookDTO);
            return new ResponseEntity<BookDTO>(bookService.updateBook(updatedBook),HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBookByBookId(@PathVariable Long bookId){
        try {
            String s = bookService.deleteBook(bookId);
            if (s.equals("book deleted successfully")) {
                return new ResponseEntity<String>(s, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<String>(s,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
