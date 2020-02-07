package com.gmail.andrewTyshkovets;

public class Main {
    public static void main(String[] args) {
       Rectangular rec = new Rectangular(5,4);
           rec.drawFigure(rec.getRectangule());
        System.out.println();
        RectangularTiangle rectangularTiangle = new RectangularTiangle(5,5);
           rectangularTiangle.drawFigure(rectangularTiangle.getRectangularTriangle());



    }
}
