package com.shubh.library_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.entity.BorrowedBook;
import com.shubh.library_management.entity.User;
import com.shubh.library_management.exception.BookNotAvailable;
import com.shubh.library_management.exception.UserAlreadyBorrowedBook;
import com.shubh.library_management.mapper.BorrowedBookMapper;
import com.shubh.library_management.repository.BorrowedBookRepository;

@Service
public class BorrowedBookimpl implements BorrowedBookService{
    BorrowedBookMapper borrowedBookMapper = new BorrowedBookMapper();
    private BorrowedBookRepository borrowedBookRepository;
    private UserService userService;
    private BookService bookService;

    public BorrowedBookimpl(BorrowedBookMapper borrowedBookMapper, BorrowedBookRepository borrowedBookRepository,
        UserService userService, BookService bookService) {
        this.borrowedBookMapper = borrowedBookMapper;
        this.borrowedBookRepository = borrowedBookRepository;
        this.userService = userService;
        this.bookService = bookService;
    }

    public boolean isBookAvailable(int count){
        if (count == 0) {
            return false;
        }
        return true;
    }

    public BorrowedBookDTO borrowingBook(BorrowedBookDTO borrowedBookDTO){
        Long bookId = borrowedBookDTO.getBookId();
        Long userId = borrowedBookDTO.getUserId();
        Book book = bookService.getBookbyId(bookId);
        User user = userService.getUserById(userId);
        
        if (!checkIfUserCanBorrowBook(userId, bookId)) {
            throw new UserAlreadyBorrowedBook("you have already borrowed one copy of this book");
        }
        if (!isBookAvailable(book.getBookCount())) {
            throw new BookNotAvailable("book is not available");
        }
        BorrowedBook borrowedBook = borrowedBookMapper.mapToBorrowedBook(borrowedBookDTO,book,user);
        borrowedBookRepository.save(borrowedBook);
        book.setBookCount(book.getBookCount() - 1);
        bookService.updateBook(book);
        return borrowedBookMapper.mapToBorrowedBookDTO(borrowedBook);
    }

    public boolean checkIfUserCanBorrowBook(Long userId, Long bookId){
        List<BorrowedBookDTO> listOfBorrowedBookDTOs = getAllBorrowedBooks();
        for(BorrowedBookDTO borrowedBookDTO : listOfBorrowedBookDTOs){
            if (borrowedBookDTO.getUserId() == userId && borrowedBookDTO.getBookId() == bookId) {
                return false;
            }
        }
        return true;
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
