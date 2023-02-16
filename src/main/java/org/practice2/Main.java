package org.practice2;

import java.beans.*;
import java.math.BigInteger;
import java.util.Random;

import org.practice2.example.*;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws Exception {
        String token = login("adminUser", "pass");
        System.out.println("Token: " + token);
    }

    static String login(String username, String password) {
        if (username.equals("admin")) {
            if (password.equals("password")) {
                return "succeed";
            } else {
                throw new LoginFailedException("incorrect username or password");
            }
        } else {
            throw new UserNotFoundException("User not found");
        }

    }

    static class LoginFailedException extends BaseException {
        public LoginFailedException(String message) {
            super(message);
        }
    }

    static class UserNotFoundException extends BaseException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

}

