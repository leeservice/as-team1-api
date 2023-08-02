package org.kainos.ea.validatorTests;

import org.junit.jupiter.api.Test;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.model.RegisterUser;
import org.kainos.ea.model.enums.UserRole;
import org.kainos.ea.validator.RegisterUserValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RegisterUserValidatorTest {

    RegisterUserValidator registerUserValidator = new RegisterUserValidator();
    @Test
    void isValidRegisterUser_shouldReturnEmptyString_whenPassedAValidUser() {
        RegisterUser login = new RegisterUser("JTeague@servicemail.com", "Lee@YourService123", UserRole.EMPLOYEE);
        assertEquals("", registerUserValidator.isValidRegisterUser(login));
    }

    @Test
    void isValidRegisterUser_shouldReturnInvalidEmail_whenInvalidEmail() {
        RegisterUser login = new RegisterUser("JTeagueservicemail", "Lee@YourService123", UserRole.EMPLOYEE);
        assertEquals("Invalid email.", registerUserValidator.isValidRegisterUser(login));
    }

    @Test
    void isValidRegisterUser_shouldReturnInvalidPassword_whenPasswordDoesNotContainUpper() {
        RegisterUser login = new RegisterUser("JTeague@servicemail.com", "lee@yourservice123", UserRole.EMPLOYEE);
        assertEquals("Invalid password.", registerUserValidator.isValidRegisterUser(login));
    }

    @Test
    void isValidRegisterUser_shouldReturnInvalidPassword_whenPasswordDoesNotContainLower() {
        RegisterUser login = new RegisterUser("JTeague@servicemail.com", "LEE@YOURSERVICE123", UserRole.EMPLOYEE);
        assertEquals("Invalid password.", registerUserValidator.isValidRegisterUser(login));
    }

    @Test
    void isValidRegisterUser_shouldReturnInvalidPassword_whenPasswordDoesNotContainSpecial() {
        RegisterUser login = new RegisterUser("JTeague@servicemail.com", "LeeYourService123", UserRole.EMPLOYEE);
        assertEquals("Invalid password.", registerUserValidator.isValidRegisterUser(login));
    }

    @Test
    void isValidRegisterUser_shouldReturnInvalidPassword_whenPasswordDoesNotContainDigit() {
        RegisterUser login = new RegisterUser("JTeague@servicemail.com", "LeeYourService@", UserRole.EMPLOYEE);
        assertEquals("Invalid password.", registerUserValidator.isValidRegisterUser(login));
    }


}
