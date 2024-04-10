package com.shubh.library_management.mapper;

import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.entity.BorrowedBook;

public class BorrowedBookMapper {
    public static BorrowedBookDTO mapToBorrowedBookDTO(BorrowedBook borrowedBook){
        BorrowedBookDTO borrowedBookDTO = new BorrowedBookDTO(
            borrowedBook.getBorrowedBookId(),
            borrowedBook.getBook(),
            borrowedBook.getUser(),
            borrowedBook.getBookName(),
            borrowedBook.getUserName(),
            borrowedBook.isReturned()
        );

        return borrowedBookDTO;
    }

    public static BorrowedBook mapToBorrowedBook(BorrowedBookDTO borrowedBookDTO){
        BorrowedBook borrowedBook = new BorrowedBook(
            borrowedBookDTO.getBorrowedBookId(),
            borrowedBookDTO.getBook(),
            borrowedBookDTO.getUser(),
            borrowedBookDTO.getBookName(),
            borrowedBookDTO.getUserName(),
            borrowedBookDTO.isReturned()
        );

        return borrowedBook;
    }
}
