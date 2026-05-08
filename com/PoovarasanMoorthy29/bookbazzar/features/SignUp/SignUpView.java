package com.bookbazzar.features.SignUp;
import com.bookbazzar.data.dto.Role;
import com.bookbazzar.features.BaseView;
import java.util.Scanner;
public class SignUpView implements BaseView {
    private SignUpPresenter presenter;
    public SignUpView() {
        this.presenter = new SignUpPresenter(this);
    }
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Sign Up ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println("Select Role: 1. BUYER 2. SELLER");
        String roleChoice = scanner.nextLine();
        Role role = null;
        if (roleChoice.equals("1")) {
            role = Role.BUYER;
        } else if (roleChoice.equals("2")) {
            role = Role.SELLER;
        } else {
            System.out.println("Invalid role choice.");
            return;
        }
        presenter.signUp(username, password, role);
    }
    public void onSuccess() {
        System.out.println("Registration successful. You can now login.");
    }
    public void onError(String message) {
        System.out.println("Error: " + message);
    }
}
