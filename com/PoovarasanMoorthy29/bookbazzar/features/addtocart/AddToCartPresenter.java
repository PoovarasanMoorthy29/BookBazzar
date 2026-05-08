package com.bookbazzar.features.addtocart;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.Order;
import com.bookbazzar.data.repository.BookBazzarDB;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class AddToCartPresenter {
    private AddToCartView view;
    public AddToCartPresenter(AddToCartView view) {
        this.view = view;
    }
    public void viewBooks() {
        view.showBooks(BookBazzarDB.getInstance().getBooks());
    }
    public void viewCart(String userId) {
        List<Book> cart = BookBazzarDB.getInstance().getCarts().getOrDefault(userId, new ArrayList<>());
        if (cart.isEmpty()) {
            view.showMessage("Your cart is empty.");
        } else {
            double total = 0;
            for (Book b : cart) {
                view.showMessage("- " + b.getTitle() + " ($" + b.getPrice() + ")");
                total += b.getPrice();
            }
            view.showMessage("Total: $" + total);
        }
    }
    public void addToCart(String userId, String bookId) {
        for (Book b : BookBazzarDB.getInstance().getBooks()) {
            if (b.getId().equals(bookId)) {
                BookBazzarDB.getInstance().getCarts().computeIfAbsent(userId, k -> new ArrayList<>()).add(b);
                view.showMessage("Added " + b.getTitle() + " to cart.");
                return;
            }
        }
        view.showMessage("Book not found.");
    }
    public void checkout(String userId) {
        List<Book> cart = BookBazzarDB.getInstance().getCarts().get(userId);
        if (cart == null || cart.isEmpty()) {
            view.showMessage("Cart is empty. Cannot checkout.");
            return;
        }
        double total = 0;
        for (Book b : cart) {
            total += b.getPrice();
        }
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, userId, new ArrayList<>(cart), total);
        BookBazzarDB.getInstance().getOrders().add(order);
        BookBazzarDB.getInstance().getCarts().remove(userId);
        view.showMessage("Checkout successful! Order ID: " + orderId + " Total: $" + total);
    }
}
