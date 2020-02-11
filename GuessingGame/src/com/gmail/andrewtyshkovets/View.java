package com.gmail.andrewtyshkovets;

public class View {
    public static final String HIGHER_NUMBER_MESSAGE = "My number is bigger";
    public static final String LOWER_NUMBER_MESSAGE = "My number is smaller";
    public static final String INPUT_MESSAGE = "Input your integer number in range from ";
    public static final String INVALID_NUMBER_MESSAGE = "Your number is out of range";
    public static final String WRONG_MESSAGE = "Try again";
    public static final String LIST_OF_TRIES_MESSAGE = "Your tries";
    public static final String VICTORY_MESSAGE = "Congratulations!!! You won! My number is ";
    public static final String TRIES_MESSAGE = "To guess my number you spent this amount of tries: ";

    public void printMsg(String message) {
        System.out.println(message);
    }

}
