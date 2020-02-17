/** @author: Andriy Tyshkovets */
package com.company;

public class TankyDroid extends Droid {

    private int shield;

    public TankyDroid() {
        this.setStrength(35);
        this.setVelocity(5);
        this.shield=100;
        this.setBatteryLife(60+shield);
        this.setDroidName("TankyDroid");

        heal();
    }




    public void heal(){
        setSuperPower(new HealPower());
    }

}
