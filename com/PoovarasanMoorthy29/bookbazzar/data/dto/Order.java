package com.bookbazzar.data.dto;
import java.util.List;
public class Order {
    private String orderId;
    private String buyerId;
    private List<Book> books;
    private double totalAmount;
    public Order(String orderId, String buyerId, List<Book> books, double totalAmount) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.books = books;
        this.totalAmount = totalAmount;
    }
    public String getOrderId() { return orderId; }
    public String getBuyerId() { return buyerId; }
    public List<Book> getBooks() { return books; }
    public double getTotalAmount() { return totalAmount; }
}
