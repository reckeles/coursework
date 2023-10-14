package org.coursework.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.coursework.model.Authorization;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Authorization {
    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
    private Integer id;

    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.name = null;
        this.email = null;
        this.role = null;
    }

    public User(String username,
                String password,
                String name,
                String email,
                String role) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
