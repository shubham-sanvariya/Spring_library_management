package com.shubh.library_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.entity.BorrowedBook;
import com.shubh.library_management.entity.User;
import com.shubh.library_management.mapper.BorrowedBookMapper;
import com.shubh.library_management.repository.BorrowedBookRepository;

@Service
public class BorrowedBookimpl implements BorrowedBookService{
    BorrowedBookMapper borrowedBookMapper = new BorrowedBookMapper();
    private BorrowedBookRepository borrowedBookRepository;

    private BookService bookService;

    public BorrowedBookimpl(BorrowedBookRepository borrowedBookRepository, BookService bookService) {
        this.borrowedBookRepository = borrowedBookRepository;
        this.bookService = bookService;
    }

    public boolean isBookAvailable(int count){
        if (count == 0) {
            return false;
        }
        return true;
    }

    public BorrowedBookDTO borrowingBook(BorrowedBookDTO borrowedBookDTO, Book book, User user){
        if (!isBookAvailable(book.getBookCount())) {
            throw new RuntimeException("book is not available");
        }
        BorrowedBook borrowedBook = borrowedBookMapper.mapToBorrowedBook(borrowedBookDTO,book,user);
        borrowedBookRepository.save(borrowedBook);
        return borrowedBookMapper.mapToBorrowedBookDTO(borrowedBook);
    }

    public List<BorrowedBookDTO> getAllBorrowedBooks() {
        return borrowedBookRepository.findAll().stream()
            .filter((borrowedBook) -> borrowedBook.isReturned() != true)
            .map((borrowedBook) -> borrowedBookMapper.mapToBorrowedBookDTO(borrowedBook)).toList();
    }

    public BorrowedBookDTO returnBook(Long borrowingBookId){
        BorrowedBook borrowedBook = borrowedBookRepository.findById(borrowingBookId)
        .orElseThrow(() -> new RuntimeException("no entry of borrowed book found by this id"));

        borrowedBook.setReturned(true);
        Book book = bookService.getBookbyId(borrowedBook.getBook().getBookId());
        book.setBookCount(book.getBookCount()+1);
        bookService.updateBook(book);
        
        return borrowedBookMapper.mapToBorrowedBookDTO(borrowedBook);  
    }
}
