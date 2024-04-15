package com.shubh.library_management.mapper;

import com.shubh.library_management.dto.BookDTO;
import com.shubh.library_management.entity.Book;

public class BookMapper {
    public static Book mapToBook(BookDTO bookDTO){
        Book book = new Book(
            bookDTO.getBookId(),
            bookDTO.getBookName(),
            bookDTO.getBookAuthor(),
            bookDTO.getBookCount(),
            bookDTO.getTotalBookCount()
        );

        return book;
    }

    public static BookDTO mapToBookDTO(Book book){
        BookDTO bookDTO = new BookDTO(
            book.getBookId(),
            book.getBookName(),
            book.getBookAuthor(),
            book.getBookCount(),
            book.getTotalBookCount()
        );

        return bookDTO;
    }
}
