package com.gmail.andrewTyshkovets;

public class Figure {

    public static void drawFigure(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               if(arr[i][j]==1){
                   System.out.print("*");
               }
               else {
                   System.out.print(" ");
               }
            }
            System.out.println();
        }
    }
}
