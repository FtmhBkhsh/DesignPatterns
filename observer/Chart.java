package com.learning.observer;

public class Chart implements Observer{
    @Override
    public void update(int value) {
        System.out.println("chart got updated:"+ value);
    }
}
