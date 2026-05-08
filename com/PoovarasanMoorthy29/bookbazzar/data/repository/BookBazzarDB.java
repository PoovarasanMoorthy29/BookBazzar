package com.bookbazzar.data.repository;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.Order;
import com.bookbazzar.data.dto.Role;
import com.bookbazzar.data.dto.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BookBazzarDB {
    private static BookBazzarDB instance;
    private List<User> users;
    private List<Book> books;
    private List<Order> orders;
    private Map<String, List<Book>> carts;
    private Map<String, List<Book>> favourites;
    private BookBazzarDB() {
        users = new ArrayList<>();
        books = new ArrayList<>();
        orders = new ArrayList<>();
        carts = new HashMap<>();
        favourites = new HashMap<>();
        users.add(new User("1", "admin", "admin123", Role.ADMIN));
    }
    public static BookBazzarDB getInstance() {
        if (instance == null) {
            instance = new BookBazzarDB();
        }
        return instance;
    }
    public List<User> getUsers() { return users; }
    public List<Book> getBooks() { return books; }
    public List<Order> getOrders() { return orders; }
    public Map<String, List<Book>> getCarts() { return carts; }
    public Map<String, List<Book>> getFavourites() { return favourites; }
}
