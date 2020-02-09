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
        ArrayList<Integer> tries = new ArrayList<Integer>();
        int myNumber;
        do {
            view.printMsg(view.INPUT_MESSAGE + model.getMinValue() + " to " + model.getMaxValue());
            myNumber = Integer.parseInt(br.readLine());
            try {
                if (checkValidNum(myNumber)) {
                    tries.add(myNumber);
                    System.out.println(view.LIST_OF_TRIES_MESSAGE + tries);
                    if (checkMatching(myNumber)) {
                        view.printMsg(view.VICTORY_MESSAGE + model.getInitialNumber());
                    } else {
                        view.printMsg(view.WRONG_MESSAGE);
                    }
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }

        } while (myNumber != model.getInitialNumber());

        view.printMsg(view.TRIES_MESSAGE + tries.size());

    }

    public boolean checkMatching(int ourNumber) {
        if (ourNumber == model.getInitialNumber()) {
            return true;
        } else {
            checkBiggerOrSmaller(ourNumber);
            return false;
        }
    }

    public boolean checkValidNum(int ourNumber) throws Exception {
        if (ourNumber > model.getMinValue() && ourNumber < model.getMaxValue()) {
            setMinMax(ourNumber);
            return true;
        } else {
            throw new Exception();
        }
    }

    public void setMinMax(int number) {
        if (number > model.getMinValue() && number < model.getInitialNumber()) {
            model.setMinValue(number);
        }
        if (number < model.getMaxValue() && number > model.getInitialNumber()) {
            model.setMaxValue(number);
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
