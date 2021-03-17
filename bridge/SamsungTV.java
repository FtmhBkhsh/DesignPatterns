package com.learning.bridge;

public class SamsungTV implements Device{
    @Override
    public void turn_on() {
        System.out.println("Samsung:turn on");
    }

    @Override
    public void turn_off() {
        System.out.println("Samsung:turn off");
    }

    @Override
    public void set_channel(int number) {
        System.out.println("Samsung:set channel");
    }
}
