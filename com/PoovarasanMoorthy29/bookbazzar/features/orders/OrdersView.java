package com.bookbazzar.features.orders;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.Order;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import java.util.List;
public class OrdersView implements BaseView {
    private User user;
    private OrdersPresenter presenter;
    public OrdersView(User user) {
        this.user = user;
        this.presenter = new OrdersPresenter(this);
    }
    public void show() {
        System.out.println("--- Orders ---");
        presenter.fetchOrders(user);
    }
    public void showOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        for (Order o : orders) {
            System.out.println("Order ID: " + o.getOrderId() + " | Total: $" + o.getTotalAmount());
            for (Book b : o.getBooks()) {
                System.out.println("  - " + b.getTitle() + " ($" + b.getPrice() + ")");
            }
        }
    }
}
