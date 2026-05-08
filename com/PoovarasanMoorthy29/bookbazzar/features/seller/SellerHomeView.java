package com.bookbazzar.features.seller;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import com.bookbazzar.features.addbook.AddBookView;
import com.bookbazzar.features.myInventory.MyInventoryView;
import com.bookbazzar.features.search.SearchView;
import com.bookbazzar.features.updatebook.UpdateBookView;
import java.util.Scanner;
public class SellerHomeView implements BaseView {
    private User seller;
    public SellerHomeView(User seller) {
        this.seller = seller;
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- Seller Dashboard ---");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. My Inventory");
            System.out.println("4. Search Book");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": new AddBookView(seller).show(); break;
                case "2": new UpdateBookView(seller).show(); break;
                case "3": new MyInventoryView(seller).show(); break;
                case "4": new SearchView(seller).show(); break;
                case "5": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
