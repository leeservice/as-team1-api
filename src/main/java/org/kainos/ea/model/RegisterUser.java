package org.kainos.ea.model;

import org.kainos.ea.model.enums.UserRole;

public class RegisterUser {

    private String email;
    private String password;

    private UserRole role;

    public RegisterUser(String email, String password, UserRole role) {
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }



}
