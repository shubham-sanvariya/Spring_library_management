package com.shubh.library_management.mapper;

import org.springframework.stereotype.Service;

import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.entity.BorrowedBook;
import com.shubh.library_management.entity.User;

@Service
public class BorrowedBookMapper {

    public BorrowedBookMapper() {
    }

    public BorrowedBookDTO mapToBorrowedBookDTO(BorrowedBook borrowedBook){
        BorrowedBookDTO borrowedBookDTO = new BorrowedBookDTO(
            borrowedBook.getBorrowedBookId(),
            borrowedBook.getBook().getBookId(),
            borrowedBook.getUser().getUserId(),
            borrowedBook.getBook().getBookName(),
            borrowedBook.getUser().getUserName(),
            borrowedBook.isReturned()
        );
        System.out.println(borrowedBook.getBorrowedBookId());
        return borrowedBookDTO;
    }

    public BorrowedBook mapToBorrowedBook(BorrowedBookDTO borrowedBookDTO,Book book,User user){       
        BorrowedBook borrowedBook = new BorrowedBook(
            borrowedBookDTO.getBorrowedBookId(),
            book,
            user,
            borrowedBookDTO.isReturned()
        );

        return borrowedBook;
    }
}
