package com.bookbazzar.features.myInventory;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.Role;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.data.repository.BookBazzarDB;
import java.util.ArrayList;
import java.util.List;
public class MyInventoryPresenter {
    private MyInventoryView view;
    public MyInventoryPresenter(MyInventoryView view) {
        this.view = view;
    }
    public void fetchInventory(User user) {
        List<Book> allBooks = BookBazzarDB.getInstance().getBooks();
        List<Book> userBooks = new ArrayList<>();
        for (Book b : allBooks) {
            if (user.getRole() == Role.ADMIN || b.getSellerId().equals(user.getId())) {
                userBooks.add(b);
            }
        }
        view.showInventory(userBooks);
    }
}
