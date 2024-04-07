package com.shubh.library_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookName;

    private String bookAuthor;

    private Integer bookCount;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User borrwedBy;

    public Book() {
    }

    public Book(Long bookId, String bookName, String bookAuthor, Integer bookCount, User borrwedBy) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCount = bookCount;
        this.borrwedBy = borrwedBy;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public User getBorrwedBy() {
        return borrwedBy;
    }

    public void setBorrwedBy(User borrwedBy) {
        this.borrwedBy = borrwedBy;
    }
}
