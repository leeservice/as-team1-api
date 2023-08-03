package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kainos.ea.model.enums.UserRole;

public class RegisterUser {

    private String email;
    private String password;

    private UserRole role;

    @Override
    public String toString() {
        return "RegisterUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @JsonCreator
    public RegisterUser(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("role") UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
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
