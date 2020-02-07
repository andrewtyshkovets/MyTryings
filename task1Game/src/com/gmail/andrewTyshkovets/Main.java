package com.gmail.andrewTyshkovets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import static com.gmail.andrewTyshkovets.View.*;

public class Main {
    public static void main(String[] args) {
        Number nb = new Number();
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        getInitInputMsg();
        try {
            try {
                nb.setUsersNumber(Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        while (nb.getInitialNumber()!=nb.getUsersNumber()){
            System.out.println(nb.getTries());
            nb.compare(nb.getUsersNumber());
            nb.setMinMax(nb.getUsersNumber());
            nb.getRange();

            getInputMsg();

            try {
                nb.setUsersNumber(Integer.parseInt(br.readLine()));
            } catch (Exception | IOException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
        System.out.println(nb.getTries());
        nb.victory();
        nb.getAmountOfTries();


    }
}
