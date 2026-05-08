package com.bookbazzar.features.myInventory;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import java.util.List;
public class MyInventoryView implements BaseView {
    private User user;
    private MyInventoryPresenter presenter;
    public MyInventoryView(User user) {
        this.user = user;
        this.presenter = new MyInventoryPresenter(this);
    }
    public void show() {
        System.out.println("--- My Inventory ---");
        presenter.fetchInventory(user);
    }
    public void showInventory(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
        for (Book b : books) {
            System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle() + " | Author: " + b.getAuthor() + " | Price: $" + b.getPrice());
        }
    }
}
