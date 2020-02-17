package com.company;

public class InvalidUsernameEcxeption extends Exception {
    @Override
    public String getMessage() {
        return AutorizationView.INVALID_USERNAME_MSG;
    }
}
