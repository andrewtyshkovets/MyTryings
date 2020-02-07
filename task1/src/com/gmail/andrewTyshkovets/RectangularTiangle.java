package com.gmail.andrewTyshkovets;

public class RectangularTiangle extends Figure {
    private int width;
    private int height;

    public RectangularTiangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public RectangularTiangle() {
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

    public int[][] getRectangularTriangle(){
        int [][] arr = new int[height][width];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i==height-1 || j==0 || j==i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }

}
