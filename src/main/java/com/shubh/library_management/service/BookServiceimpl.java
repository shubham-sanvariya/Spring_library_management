package com.shubh.library_management.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.shubh.library_management.dto.BookDTO;
import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.mapper.BookMapper;
import com.shubh.library_management.repository.BookRepository;

@Service
public class BookServiceimpl implements BookService{
    private BookRepository bookRepository;

    private BorrowedBookService borrowedBookService;

    public BookServiceimpl(BookRepository bookRepository, @Lazy BorrowedBookService borrowedBookService) {
        this.bookRepository = bookRepository;
        this.borrowedBookService = borrowedBookService;
    }

    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll().stream()
        .map((book) -> BookMapper.mapToBookDTO(book)).toList();
    }

    public Book getBookbyId(Long bookId){
        return bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("no book found by this book id"));
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = BookMapper.mapToBook(bookDTO);
        book.setBookCount(bookDTO.getTotalBookCount());
        bookRepository.save(book);

        return BookMapper.mapToBookDTO(book);
    }

    public BookDTO updateBook(Book book) {
        return BookMapper.mapToBookDTO(bookRepository.save(book));
    }

    public String deleteBook(Long bookId){
        if (isBookBorrowed(bookId)) {
            bookRepository.deleteById(bookId);
            return "book deleted successfully";
        }else{
            return "book will be deleted when all the user's have returned the book.";
        }
    }

    public boolean isBookBorrowed(Long bookId){
        List<BorrowedBookDTO> borrowedBooks = borrowedBookService.getAllBorrowedBooks();

        for (BorrowedBookDTO borrowedBookDTO : borrowedBooks) {
            if (borrowedBookDTO.getBookId() == bookId && borrowedBookDTO.isReturned() == false) {
                Book book = getBookbyId(bookId);
                book.setBookCount(0);
                book.setSetToDeleted(true);
                updateBook(book);
                return false;
            }
        }
        return true;
    }
}
