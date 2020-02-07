package com.gmail.andrewTyshkovets;

public class Rectangular extends Figure{
    private int width;
    private int height;

    public Rectangular(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangular() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getRectangule(){
        int [][] arr = new int[height][width];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i==0 || i==height-1 || j==0 || j==width-1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }



}
