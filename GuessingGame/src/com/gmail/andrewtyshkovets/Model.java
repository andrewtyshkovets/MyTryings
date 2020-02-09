package com.gmail.andrewtyshkovets;

import java.util.Random;

public class Model {
    private Random rn = new Random();
    private int initialNumber = rn.nextInt(100);
    private int minValue = 0;
    private int maxValue = 100;


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
}
