package com.bookbazzar.data.dto;
public class Book {
    private String id;
    private String title;
    private String author;
    private double price;
    private String sellerId;
    public Book(String id, String title, String author, double price, String sellerId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.sellerId = sellerId;
    }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getSellerId() { return sellerId; }
}
