package com.bookbazzar.data.dto;
public class User {
    private String id;
    private String username;
    private String password;
    private Role role;
    public User(String id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }
}
