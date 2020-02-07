package com.gmail.andrewTyshkovets;

public class equilateralTriangle {
    private  int side;

    public equilateralTriangle(int side) {
        this.side = side;
    }

    public equilateralTriangle() {
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int[][] getEquilateralTriangle(){
        int [][] arr = new int[side][side];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i==side-1 ){
                    arr[i][j]=1;
                } else {
                    arr[i][j]=0;
                }
            }
        }

        return arr;
    }
}
