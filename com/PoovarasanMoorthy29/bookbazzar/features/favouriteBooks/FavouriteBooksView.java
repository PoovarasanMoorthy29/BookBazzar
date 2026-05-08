package com.bookbazzar.features.favouriteBooks;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import java.util.List;
import java.util.Scanner;
public class FavouriteBooksView implements BaseView {
    private User user;
    private FavouriteBooksPresenter presenter;
    public FavouriteBooksView(User user) {
        this.user = user;
        this.presenter = new FavouriteBooksPresenter(this);
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- Favourite Books ---");
            System.out.println("1. View Favourites");
            System.out.println("2. Add to Favourites");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": presenter.viewFavourites(user.getId()); break;
                case "2":
                    System.out.print("Enter Book ID to add: ");
                    String bookId = scanner.nextLine();
                    presenter.addFavourite(user.getId(), bookId);
                    break;
                case "3": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    public void showMessage(String msg) {
        System.out.println(msg);
    }
    public void showBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No favourite books yet.");
            return;
        }
        for (Book b : books) {
            System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle() + " | Author: " + b.getAuthor());
        }
    }
}
