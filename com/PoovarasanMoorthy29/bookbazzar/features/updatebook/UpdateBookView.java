package com.bookbazzar.features.updatebook;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.Role;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import java.util.List;
import java.util.Scanner;
public class UpdateBookView implements BaseView {
    private User user;
    private UpdateBookPresenter presenter;
    public UpdateBookView(User user) {
        this.user = user;
        this.presenter = new UpdateBookPresenter(this);
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Update Book ---");
        presenter.fetchBooks(user);
    }
    public void showBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available to update.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println((i + 1) + ". " + b.getTitle() + " by " + b.getAuthor() + " - $" + b.getPrice());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select book to update (number) or 0 to cancel: ");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid choice.");
            return;
        }
        if (choice > 0 && choice <= books.size()) {
            Book b = books.get(choice - 1);
            System.out.print("New Title (" + b.getTitle() + "): ");
            String title = scanner.nextLine();
            if (title.isEmpty()) title = b.getTitle();
            System.out.print("New Author (" + b.getAuthor() + "): ");
            String author = scanner.nextLine();
            if (author.isEmpty()) author = b.getAuthor();
            System.out.print("New Price (" + b.getPrice() + "): ");
            String priceStr = scanner.nextLine();
            double price = b.getPrice();
            if (!priceStr.isEmpty()) {
                try {
                    price = Double.parseDouble(priceStr);
                } catch (Exception e) {
                    System.out.println("Invalid price. Keeping old price.");
                }
            }
            presenter.updateBook(b.getId(), title, author, price);
        }
    }
    public void onSuccess() {
        System.out.println("Book updated successfully.");
    }
    public void onError(String message) {
        System.out.println("Error: " + message);
    }
}
