package com.gmail.andrewtyshkovets;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    private Random rn = new Random();
    private int initialNumber = rn.nextInt(100);
    private int minValue = 0;
    private int maxValue = 100;
    ArrayList<Integer> tries = new ArrayList<Integer>();

    public Model(int initialNumber) {
        this.initialNumber = initialNumber;
    }

    public Model() {
    }

    public int getInitialNumber() {
        return initialNumber;
    }

    public void setInitialNumber(int initialNumber) {
        this.initialNumber = initialNumber;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public ArrayList<Integer> getTries() {
        return tries;
    }

    public boolean checkMatching(int ourNumber) {
        tries.add(ourNumber);
        if (ourNumber == initialNumber) {
            return true;
        } else {
            setMinMax(ourNumber);
            return false;
        }
    }

    public void setMinMax(int number) {
        if (number > initialNumber) {
            maxValue = number;
        } else {
            minValue = number;
        }
    }

}
