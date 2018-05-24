package com.stu.entity;

import java.sql.Date;

public class Book {
    private String bookId;
    private String bookName;
    private Date borrowTime;
    private Date returnTime;
    private Integer expirationTime;
    private String expiration;
    private Student student;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != null ? !bookId.equals(book.bookId) : book.bookId != null) return false;
        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
        if (borrowTime != null ? !borrowTime.equals(book.borrowTime) : book.borrowTime != null) return false;
        if (returnTime != null ? !returnTime.equals(book.returnTime) : book.returnTime != null) return false;
        if (expirationTime != null ? !expirationTime.equals(book.expirationTime) : book.expirationTime != null)
            return false;
        if (expiration != null ? !expiration.equals(book.expiration) : book.expiration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (borrowTime != null ? borrowTime.hashCode() : 0);
        result = 31 * result + (returnTime != null ? returnTime.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (expiration != null ? expiration.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", borrowTime=" + borrowTime +
                ", returnTime=" + returnTime +
                ", expirationTime=" + expirationTime +
                ", expiration='" + expiration + '\'' +
                ", student=" + student +
                '}';
    }
}
