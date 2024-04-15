package com.shubh.library_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubh.library_management.dto.BookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.mapper.BookMapper;
import com.shubh.library_management.repository.BookRepository;

@Service
public class BookServiceimpl implements BookService{
    private BookRepository bookRepository;

    public BookServiceimpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll().stream()
        .map((book) -> BookMapper.mapToBookDTO(book)).toList();
    }

    public Book getBookbyId(Long bookId){
        return bookRepository.findById(bookId).get();
    }


    public BookDTO createBook(BookDTO bookDTO) {
        Book book = BookMapper.mapToBook(bookDTO);
        book.setTotalBookCount(bookDTO.getBookCount());
        bookRepository.save(book);

        return BookMapper.mapToBookDTO(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
}
