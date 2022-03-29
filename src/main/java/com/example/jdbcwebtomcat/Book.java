package com.example.jdbcwebtomcat;

public class Book {

    private String bid;
    private String author;
    private String status;
    private String title;

    public Book() {
    }

    public Book(String bid, String author, String status, String title) {
        this.bid = bid;
        this.author = author;
        this.status = status;
        this.title = title;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
