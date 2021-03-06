/** @author: Andriy Moskalenko */
package com.company;

import java.util.Random;

public class RandomDroid extends Droid {
    Random randomEngine = new Random();

    public RandomDroid() {
        this.setStrength(33);
        this.setVelocity(34);
        this.setBatteryLife(33);
        this.setDroidName("RandomDroid");
    }

    @Override
    public int getStrength() {
        return randomEngine.nextBoolean() ? super.getStrength()*2 : 1;
    }

    @Override
    public int getVelocity() {
        return randomEngine.nextBoolean() ? super.getVelocity()*2 : 1;
    }

    @Override
    public int getBatteryLife() {
        return randomEngine.nextBoolean() ? super.getBatteryLife()*2 : 1;
    }
}
