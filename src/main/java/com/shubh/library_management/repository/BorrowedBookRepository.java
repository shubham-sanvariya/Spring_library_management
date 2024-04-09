package com.shubh.library_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubh.library_management.entity.BorrowedBook;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook,Long>{
    
}
