package com.shubh.library_management.dto;

import com.shubh.library_management.entity.Book;
import com.shubh.library_management.entity.User;

public class BorrowedBookDTO {
    private Long borrowedBookId;

    private Book book;

    private User user;

    private String bookName;

    private String userName;

    private boolean returned;

    public BorrowedBookDTO(Long borrowedBookId, Book book, User user, String bookName, String userName,
            boolean returned) {
        this.borrowedBookId = borrowedBookId;
        this.book = book;
        this.user = user;
        this.bookName = bookName;
        this.userName = userName;
        this.returned = returned;
    }

    public Long getBorrowedBookId() {
        return borrowedBookId;
    }

    public void setBorrowedBookId(Long borrowedBookId) {
        this.borrowedBookId = borrowedBookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
