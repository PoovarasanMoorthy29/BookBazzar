package com.bookbazzar.features.Login;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.data.repository.BookBazzarDB;
public class LoginPresenter {
    private LoginView view;
    public LoginPresenter(LoginView view) {
        this.view = view;
    }
    public void login(String username, String password) {
        for (User user : BookBazzarDB.getInstance().getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                view.onSuccess(user);
                return;
            }
        }
        view.onError("Invalid username or password.");
    }
}
