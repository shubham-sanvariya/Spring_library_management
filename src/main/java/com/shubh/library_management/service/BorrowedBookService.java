package com.shubh.library_management.service;

import java.util.List;

import com.shubh.library_management.dto.BorrowedBookDTO;

public interface BorrowedBookService {
    BorrowedBookDTO borrowingBook(BorrowedBookDTO borrowedBookDTO);

    boolean isBookAvailable(int count);

    boolean checkIfUserCanBorrowBook(Long userId, Long bookId);

    BorrowedBookDTO returnBook(Long borrowingBookId);

    List<BorrowedBookDTO> getAllBorrowedBooks();
}
