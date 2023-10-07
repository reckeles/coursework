package org.coursework.model;

import java.lang.reflect.Field;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String role;

    public User() {
    }

    public User(String username, String password, String name, String email, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
