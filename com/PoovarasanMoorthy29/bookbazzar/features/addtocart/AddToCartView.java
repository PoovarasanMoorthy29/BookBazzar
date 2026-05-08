package com.bookbazzar.features.addtocart;
import com.bookbazzar.data.dto.Book;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import java.util.List;
import java.util.Scanner;
public class AddToCartView implements BaseView {
    private User user;
    private AddToCartPresenter presenter;
    public AddToCartView(User user) {
        this.user = user;
        this.presenter = new AddToCartPresenter(this);
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- Cart & Checkout ---");
            System.out.println("1. View Available Books");
            System.out.println("2. View Cart");
            System.out.println("3. Add Book to Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": presenter.viewBooks(); break;
                case "2": presenter.viewCart(user.getId()); break;
                case "3":
                    System.out.print("Enter Book ID to add: ");
                    String bookId = scanner.nextLine();
                    presenter.addToCart(user.getId(), bookId);
                    break;
                case "4": presenter.checkout(user.getId()); break;
                case "5": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    public void showBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle() + " | Price: $" + b.getPrice());
        }
    }
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
