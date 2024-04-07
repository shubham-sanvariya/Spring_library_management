package com.shubh.library_management.dto;

import com.shubh.library_management.entity.User;

public class BookDTO {
    private Long bookId;

    private String bookName;

    private String bookAuthor;

    private Integer bookCount;

    private User borrwedBy;

    public BookDTO() {
    }

    public BookDTO(Long bookId, String bookName, String bookAuthor, Integer bookCount, User borrwedBy) {
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
