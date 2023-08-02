package org.kainos.ea.validator;

import org.kainos.ea.model.RegisterUser;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterUserValidator {

    public String isValidRegisterUser(RegisterUser user) {
        if (!isValidEmail(user.getEmail())) {
            return "Invalid email.";
        }
        if (!isValidPassword(user.getPassword())) {
            return "Invalid password.";
        }
        return "";
    }
    
    private boolean isValidEmail(String email) {

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(email).matches()) {
            return false;
        } else if (email.length() > 50) {
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        if(!m.matches()) {
            return false;
        } else if (password.length() > 50) {
            return false;
        }
        return true;
    }
}
