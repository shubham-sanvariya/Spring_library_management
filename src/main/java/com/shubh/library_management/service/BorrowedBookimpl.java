package com.shubh.library_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubh.library_management.dto.BorrowedBookDTO;
import com.shubh.library_management.entity.Book;
import com.shubh.library_management.entity.BorrowedBook;
import com.shubh.library_management.entity.User;
import com.shubh.library_management.mapper.BorrowedBookMapper;
import com.shubh.library_management.repository.BorrowedBookRepository;

@Service
public class BorrowedBookimpl implements BorrowedBookService{
    BorrowedBookMapper borrowedBookMapper = new BorrowedBookMapper();
    private BorrowedBookRepository borrowedBookRepository;

    public BorrowedBookimpl(BorrowedBookRepository borrowedBookRepository) {
        this.borrowedBookRepository = borrowedBookRepository;
    }

    public BorrowedBookDTO borrowingBook(BorrowedBookDTO borrowedBookDTO, Book book, User user){
        BorrowedBook borrowedBook = borrowedBookMapper.mapToBorrowedBook(borrowedBookDTO,book,user);
        borrowedBookRepository.save(borrowedBook);
        return borrowedBookMapper.mapToBorrowedBookDTO(borrowedBook);
    }

    public List<BorrowedBookDTO> getAllBorrowedBooks() {
        return borrowedBookRepository.findAll().stream()
            .map((borrowedBook) -> borrowedBookMapper.mapToBorrowedBookDTO(borrowedBook)).toList();
    }
}
