package com.bookbazzar.features.SignUp;
import com.bookbazzar.data.dto.Role;
import com.bookbazzar.data.dto.User;
import com.bookbazzar.data.repository.BookBazzarDB;
import java.util.UUID;
public class SignUpPresenter {
    private SignUpView view;
    public SignUpPresenter(SignUpView view) {
        this.view = view;
    }
    public void signUp(String username, String password, Role role) {
        for (User user : BookBazzarDB.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                view.onError("Username already exists.");
                return;
            }
        }
        String id = UUID.randomUUID().toString();
        User newUser = new User(id, username, password, role);
        BookBazzarDB.getInstance().getUsers().add(newUser);
        view.onSuccess();
    }
}
