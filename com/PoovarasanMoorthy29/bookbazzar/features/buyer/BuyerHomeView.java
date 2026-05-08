package com.bookbazzar.features.buyer;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import com.bookbazzar.features.addtocart.AddToCartView;
import com.bookbazzar.features.favouriteBooks.FavouriteBooksView;
import com.bookbazzar.features.orders.OrdersView;
import com.bookbazzar.features.search.SearchView;
import java.util.Scanner;
public class BuyerHomeView implements BaseView {
    private User buyer;
    public BuyerHomeView(User buyer) {
        this.buyer = buyer;
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- Buyer Dashboard ---");
            System.out.println("1. Search Book");
            System.out.println("2. Add to Cart & Checkout");
            System.out.println("3. Favourite Books");
            System.out.println("4. My Orders");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": new SearchView(buyer).show(); break;
                case "2": new AddToCartView(buyer).show(); break;
                case "3": new FavouriteBooksView(buyer).show(); break;
                case "4": new OrdersView(buyer).show(); break;
                case "5": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
