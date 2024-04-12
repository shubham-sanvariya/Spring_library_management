package com.shubh.library_management.dto;

public class BorrowedBookDTO {
    private Long borrowedBookId;

    private Long bookId;

    private Long userId;

    private String bookName;

    private String userName;

    private boolean returned;

    public BorrowedBookDTO() {
    }

    public BorrowedBookDTO(Long borrowedBookId, Long bookId, Long userId, String bookName, String userName,
            boolean returned) {
        this.borrowedBookId = borrowedBookId;
        this.bookId = bookId;
        this.userId = userId;
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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
