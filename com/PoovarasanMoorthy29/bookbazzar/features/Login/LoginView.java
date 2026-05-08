package com.bookbazzar.features.Login;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.features.BaseView;
import com.bookbazzar.features.admin.AdminHomeView;
import com.bookbazzar.features.buyer.BuyerHomeView;
import com.bookbazzar.features.seller.SellerHomeView;
import java.util.Scanner;
public class LoginView implements BaseView {
    private LoginPresenter presenter;
    public LoginView() {
        this.presenter = new LoginPresenter(this);
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Login ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        presenter.login(username, password);
    }
    public void onSuccess(User user) {
        System.out.println("Login successful! Welcome, " + user.getUsername());
        switch (user.getRole()) {
            case ADMIN:
                new AdminHomeView(user).show();
                break;
            case BUYER:
                new BuyerHomeView(user).show();
                break;
            case SELLER:
                new SellerHomeView(user).show();
                break;
        }
    }
    public void onError(String message) {
        System.out.println("Error: " + message);
    }
}
