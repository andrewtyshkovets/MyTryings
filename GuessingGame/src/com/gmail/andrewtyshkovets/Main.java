package com.gmail.andrewtyshkovets;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, Exception {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.runGame();

    }
}
