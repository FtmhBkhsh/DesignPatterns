package com.learning.bridge;

public class SonyTV implements Device{
    @Override
    public void turn_on() {
        System.out.println("Sony:turn on");
    }

    @Override
    public void turn_off() {
        System.out.println("Sony:turn off");
    }

    @Override
    public void set_channel(int number) {
        System.out.println("Sony:set channel");
    }
}
