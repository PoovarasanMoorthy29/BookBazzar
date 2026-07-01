package com.bookbazzar.features.favouriteBooks;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.repository.BookBazzarDB;
import java.util.ArrayList;
import java.util.List;
public class FavouriteBooksPresenter {
    private FavouriteBooksView view;
    public FavouriteBooksPresenter(FavouriteBooksView view) {
        this.view = view;
    }
    public void viewFavourites(String userId) {
        List<Book> favs = BookBazzarDB.getInstance().getFavourites().getOrDefault(userId, new ArrayList<>());
        view.showBooks(favs);
    }
    public void addFavourite(String userId, String bookId) {
        List<Book> favs = BookBazzarDB.getInstance().getFavourites().computeIfAbsent(userId, k -> new ArrayList<>());
        for (Book b : favs) {
            if (b.getId().equals(bookId)) {
                view.showMessage("Book is already in your favourites.");
                return;
            }
        }
        for (Book b : BookBazzarDB.getInstance().getBooks()) {
            if (b.getId().equals(bookId)) {
                favs.add(b);
                view.showMessage("Added " + b.getTitle() + " to favourites.");
                return;
            }
        }
        view.showMessage("Book not found.");
    }
}
