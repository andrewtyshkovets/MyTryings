package com.gmail.andrewTyshkovets;


import static com.gmail.andrewTyshkovets.View.getInvalidNumMsg;

public class Exception extends java.lang.Exception {
    @Override
    public String getMessage(){
        return getInvalidNumMsg();
    }
}
