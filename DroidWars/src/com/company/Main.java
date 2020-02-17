package com.company;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        AutorizationView autorizationView = new AutorizationView();
        Autorization autorization = new Autorization(user, autorizationView);
        autorization.autorize();
    }
}
