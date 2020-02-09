package com.gmail.andrewtyshkovets;

public class Exception extends java.lang.Exception {
    @Override
    public String getMessage() {
        return View.INVALID_NUMBER_MESSAGE;
    }
}
