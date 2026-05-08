package com.bookbazzar.features.search;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import java.util.List;
import java.util.Scanner;
public class SearchView implements BaseView {
    private User user;
    private SearchPresenter presenter;
    public SearchView(User user) {
        this.user = user;
        this.presenter = new SearchPresenter(this);
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Search Book ---");
        System.out.print("Enter book title or author: ");
        String query = scanner.nextLine();
        presenter.search(query);
    }
    public void showResults(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Book b : books) {
            System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle() + " | Author: " + b.getAuthor() + " | Price: $" + b.getPrice());
        }
    }
}
