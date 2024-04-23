package com.shubh.library_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookName;

    private String bookAuthor;

    private Integer bookCount;

    private Integer totalBookCount;

    private Boolean setToDeleted;

    public Book() {
    }

    public Book(Long bookId, String bookName, String bookAuthor, Integer bookCount, Integer totalBookCount,
            Boolean setToDeleted) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCount = bookCount;
        this.totalBookCount = totalBookCount;
        this.setToDeleted = setToDeleted;
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

    public Integer getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public Boolean getSetToDeleted() {
        return setToDeleted;
    }

    public void setSetToDeleted(Boolean setToDeleted) {
        this.setToDeleted = setToDeleted;
    }
}
