package com.learning.observer;

public class SpreadSheet implements Observer{
    @Override
    public void update(int value) {
        System.out.println("spreadsheet got updated:"+ value);
    }
}
