package com.gmail.andrewTyshkovets;

import java.util.ArrayList;

public class View {
    private static final String HIGHER_NUMBER_MESSAGE = "My number is bigger";
    private static final String LOWER_NUMBER_MESSAGE = "My number is smaller";
    private static final String EQUAL_NUMBER_MESSAGE = "This is my number";
    private static final String INITIAL_INPUT_MESSAGE = "Input your number in range from 0 to 100";
    private static final String INPUT_MESSAGE = "Input your number";
    private static final String INVALID_NUMBER_MESSAGE = "Your number is out of range";
    private static final String RANGE_MESSAGE = "Initial number is between ";
    private static final String VICTORY_MESSAGE = "Congratulations!!! You won! My number is ";
    private static final String TRIES_MESSAGE = "To guess my number you spent this amount of tries: ";

    public static void getHigherNumMsg(){
        System.out.println(HIGHER_NUMBER_MESSAGE);
    }

    public static void getLowerNumMsg(){
        System.out.println(LOWER_NUMBER_MESSAGE);
    }

    public static void getEqualNumMsg(){
        System.out.println(LOWER_NUMBER_MESSAGE);
    }
    public static void getInputMsg(){
        System.out.println(INPUT_MESSAGE);
    }
    public static void getInitInputMsg(){
        System.out.println(INITIAL_INPUT_MESSAGE);
    }

    public static String getInvalidNumMsg(){
        return INVALID_NUMBER_MESSAGE;
    }

    public static void getRangeMsg(int min, int max){
        System.out.println(RANGE_MESSAGE+min+" and "+max);
    }

    public static void getVictoryMsg(int number){
        System.out.println(VICTORY_MESSAGE+number);
    }

    public static void getTriesMsg(ArrayList<Integer> list){
        int tries = list.size();
        System.out.println(TRIES_MESSAGE+tries);
    }


}
