package com.shubh.library_management.service;

import java.util.List;

import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.entity.User;

public interface BorrowedBookService {
    BorrowedBookDTO borrowingBook(BorrowedBookDTO borrowedBookDTO,Book book, User user);

    boolean isBookAvailable(int count);

    List<BorrowedBookDTO> getAllBorrowedBooks();
}
