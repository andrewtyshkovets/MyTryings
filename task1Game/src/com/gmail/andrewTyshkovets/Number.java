package com.gmail.andrewTyshkovets;

import java.util.ArrayList;
import java.util.Random;


import static com.gmail.andrewTyshkovets.View.*;


public class Number {
    private Random rn = new Random();
    private int initialNumber = rn.nextInt(100);
    private int usersNumber;
    private int min = 0;
    private int max = 100;
    private ArrayList<Integer> tries = new ArrayList<>();

    public Number() {
    }

    public int getInitialNumber() {
        return initialNumber;
    }

    public int getUsersNumber() {
        return usersNumber;
    }

    public ArrayList<Integer> getTries() {
        return tries;
    }

    public void setUsersNumber(int usersNumber) throws Exception {
        if(usersNumber>=min && usersNumber<=max) {
            this.usersNumber = usersNumber;
            tries.add(usersNumber);
        } else {
            System.out.println("Your number have to be from "+min+" to "+max);
            throw new Exception();
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void compare(int usersNumber){
        if(initialNumber>usersNumber){
            getHigherNumMsg();
        } else if(initialNumber<usersNumber){
            getLowerNumMsg();
        } else {
            getEqualNumMsg();
        }
    }

    public void getRange(){
        getRangeMsg(min,max);
    }

    public void getAmountOfTries(){
        getTriesMsg(tries);
    }

    public void victory(){
        getVictoryMsg(usersNumber);
    }

    public void setMinMax(int number) {
        if(number>min && number<initialNumber ){
            min=number;
        }
        if(number<max && number>initialNumber){
            max=number;
        }
    }


}
