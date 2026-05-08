package com.bookbazzar.features.addbook;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.repository.BookBazzarDB;
import java.util.UUID;
public class AddBookPresenter {
    private AddBookView view;
    public AddBookPresenter(AddBookView view) {
        this.view = view;
    }
    public void addBook(String title, String author, double price, String sellerId) {
        if (title.isEmpty() || author.isEmpty() || price <= 0) {
            view.onError("Invalid book details.");
            return;
        }
        String id = UUID.randomUUID().toString();
        Book book = new Book(id, title, author, price, sellerId);
        BookBazzarDB.getInstance().getBooks().add(book);
        view.onSuccess();
    }
}
