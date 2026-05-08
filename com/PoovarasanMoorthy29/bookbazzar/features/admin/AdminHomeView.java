package com.bookbazzar.features.admin;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import com.bookbazzar.features.addbook.AddBookView;
import com.bookbazzar.features.addtocart.AddToCartView;
import com.bookbazzar.features.favouriteBooks.FavouriteBooksView;
import com.bookbazzar.features.myInventory.MyInventoryView;
import com.bookbazzar.features.orders.OrdersView;
import com.bookbazzar.features.search.SearchView;
import com.bookbazzar.features.updatebook.UpdateBookView;
import java.util.Scanner;
public class AdminHomeView implements BaseView {
    private User admin;
    public AdminHomeView(User admin) {
        this.admin = admin;
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- Admin Dashboard ---");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. My Inventory");
            System.out.println("4. Search Book");
            System.out.println("5. Add to Cart");
            System.out.println("6. Favourite Books");
            System.out.println("7. Orders");
            System.out.println("8. Logout");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": new AddBookView(admin).show(); break;
                case "2": new UpdateBookView(admin).show(); break;
                case "3": new MyInventoryView(admin).show(); break;
                case "4": new SearchView(admin).show(); break;
                case "5": new AddToCartView(admin).show(); break;
                case "6": new FavouriteBooksView(admin).show(); break;
                case "7": new OrdersView(admin).show(); break;
                case "8": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
