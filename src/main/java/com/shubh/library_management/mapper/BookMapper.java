package com.shubh.library_management.mapper;

import com.shubh.library_management.dto.BookDTO;
import com.shubh.library_management.entity.Book;

public class BookMapper {
    public static Book mapToBook(BookDTO bookDTO){
        Book book = new Book(
            bookDTO.getBookId(),
            bookDTO.getBookName(),
            bookDTO.getBookAuthor(),
            bookDTO.getBookCount()
        );

        return book;
    }

    public static BookDTO mapToBookDTO(Book book){
        BookDTO bookDTO = new BookDTO(
            book.getBookId(),
            book.getBookName(),
            book.getBookAuthor(),
            book.getBookCount()
        );

        return bookDTO;
    }
}
