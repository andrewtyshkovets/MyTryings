package com.gmail.andrewtyshkovets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Controller {
    private Model model;
    private View view;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Controller() {
    }

    public void runGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(model.getInitialNumber());
        int myNumber = 0;
        do {
            view.printMsg(view.INPUT_MESSAGE + model.getMinValue() + " to " + model.getMaxValue());
            try {
                myNumber = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                continue;
            }

            try {
                if (checkValidNum(myNumber)) {
                    if (model.checkMatching(myNumber)) {
                        view.printMsg(view.VICTORY_MESSAGE + model.getInitialNumber());
                    } else {
                        checkBiggerOrSmaller(myNumber);
                        view.printMsg(view.WRONG_MESSAGE);
                    }
                    System.out.println(view.LIST_OF_TRIES_MESSAGE + model.getTries());
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }

        } while (myNumber != model.getInitialNumber());

        view.printMsg(view.TRIES_MESSAGE + model.tries.size());

    }


    public boolean checkValidNum(int ourNumber) throws Exception {
        if (ourNumber > model.getMinValue() && ourNumber < model.getMaxValue()) {
            return true;
        } else {
            throw new Exception();
        }
    }


    public void checkBiggerOrSmaller(int number) {
        if (number > model.getInitialNumber()) {
            view.printMsg(view.LOWER_NUMBER_MESSAGE);
        } else {
            view.printMsg(view.HIGHER_NUMBER_MESSAGE);
        }
    }


}
