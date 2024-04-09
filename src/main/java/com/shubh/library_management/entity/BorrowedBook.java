package com.shubh.library_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowedBookId;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "book_name", insertable = false, updatable = false)
    private String bookName;

    @Column(name = "user_name", insertable = false, updatable = false)
    private String userName;

    private boolean returned;

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
        this.userName = book.getBookName();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.userName = user.getUserName();
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public String getBookName() {
        return bookName;
    }

    public String getUserName() {
        return userName;
    }

    
}
