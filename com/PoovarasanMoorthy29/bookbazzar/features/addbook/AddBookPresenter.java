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
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() || price <= 0) {
            view.onError("Invalid book details. Title/Author cannot be empty and Price must be greater than zero.");
            return;
        }
        String id = UUID.randomUUID().toString();
        Book book = new Book(id, title.trim(), author.trim(), price, sellerId);
        BookBazzarDB.getInstance().getBooks().add(book);
        view.onSuccess();
    }
}
