package com.bookbazzar.features.search;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.repository.BookBazzarDB;
import java.util.ArrayList;
import java.util.List;
public class SearchPresenter {
    private SearchView view;
    public SearchPresenter(SearchView view) {
        this.view = view;
    }
    public void search(String query) {
        if (query == null || query.trim().isEmpty()) {
            view.showResults(new ArrayList<>());
            return;
        }
        List<Book> allBooks = BookBazzarDB.getInstance().getBooks();
        List<Book> results = new ArrayList<>();
        String lowerQuery = query.trim().toLowerCase();
        for (Book b : allBooks) {
            if (b.getTitle().toLowerCase().contains(lowerQuery) || b.getAuthor().toLowerCase().contains(lowerQuery)) {
                results.add(b);
            }
        }
        view.showResults(results);
    }
}
