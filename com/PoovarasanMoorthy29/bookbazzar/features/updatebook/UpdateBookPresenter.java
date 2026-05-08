package com.bookbazzar.features.updatebook;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.Role;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.data.repository.BookBazzarDB;
import java.util.ArrayList;
import java.util.List;
public class UpdateBookPresenter {
    private UpdateBookView view;
    public UpdateBookPresenter(UpdateBookView view) {
        this.view = view;
    }
    public void fetchBooks(User user) {
        List<Book> allBooks = BookBazzarDB.getInstance().getBooks();
        List<Book> userBooks = new ArrayList<>();
        for (Book b : allBooks) {
            if (user.getRole() == Role.ADMIN || b.getSellerId().equals(user.getId())) {
                userBooks.add(b);
            }
        }
        view.showBooks(userBooks);
    }
    public void updateBook(String id, String title, String author, double price) {
        List<Book> books = BookBazzarDB.getInstance().getBooks();
        for (Book b : books) {
            if (b.getId().equals(id)) {
                b.setTitle(title);
                b.setAuthor(author);
                b.setPrice(price);
                view.onSuccess();
                return;
            }
        }
        view.onError("Book not found.");
    }
}
