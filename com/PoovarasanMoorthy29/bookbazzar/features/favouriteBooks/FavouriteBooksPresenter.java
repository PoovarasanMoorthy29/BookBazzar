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
        for (Book b : BookBazzarDB.getInstance().getBooks()) {
            if (b.getId().equals(bookId)) {
                BookBazzarDB.getInstance().getFavourites().computeIfAbsent(userId, k -> new ArrayList<>()).add(b);
                view.showMessage("Added " + b.getTitle() + " to favourites.");
                return;
            }
        }
        view.showMessage("Book not found.");
    }
}
