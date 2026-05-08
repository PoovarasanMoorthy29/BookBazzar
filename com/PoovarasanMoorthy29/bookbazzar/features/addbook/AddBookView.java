package com.bookbazzar.features.addbook;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import java.util.Scanner;
public class AddBookView implements BaseView {
    private User user;
    private AddBookPresenter presenter;
    public AddBookView(User user) {
        this.user = user;
        this.presenter = new AddBookPresenter(this);
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Add Book ---");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Price: ");
        double price = 0;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid price.");
            return;
        }
        presenter.addBook(title, author, price, user.getId());
    }
    public void onSuccess() {
        System.out.println("Book added successfully.");
    }
    public void onError(String message) {
        System.out.println("Error: " + message);
    }
}
