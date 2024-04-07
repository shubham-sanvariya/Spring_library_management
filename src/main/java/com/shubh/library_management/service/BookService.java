package com.shubh.library_management.service;

import java.util.List;

import com.shubh.library_management.dto.BookDTO;

public interface BookService {
    List<BookDTO> getAllBooks();

    BookDTO createBook(BookDTO bookDTO);
}
