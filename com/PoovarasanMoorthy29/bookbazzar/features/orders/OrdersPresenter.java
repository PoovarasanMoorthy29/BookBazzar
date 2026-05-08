package com.bookbazzar.features.orders;
import com.bookbazzar.data.dto.Order;
import com.bookbazzar.data.dto.Role;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.data.repository.BookBazzarDB;
import java.util.ArrayList;
import java.util.List;
public class OrdersPresenter {
    private OrdersView view;
    public OrdersPresenter(OrdersView view) {
        this.view = view;
    }
    public void fetchOrders(User user) {
        List<Order> allOrders = BookBazzarDB.getInstance().getOrders();
        List<Order> userOrders = new ArrayList<>();
        for (Order o : allOrders) {
            if (user.getRole() == Role.ADMIN || o.getBuyerId().equals(user.getId())) {
                userOrders.add(o);
            }
        }
        view.showOrders(userOrders);
    }
}
