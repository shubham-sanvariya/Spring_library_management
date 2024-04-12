package com.shubh.library_management.service;

import java.util.List;

import com.shubh.library_management.dto.BookDTO;
import com.shubh.library_management.entity.Book;

public interface BookService {
    List<BookDTO> getAllBooks();

    Book getBookbyId(Long bookId);

    BookDTO createBook(BookDTO bookDTO);
}
