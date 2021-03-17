package com.learning.decorator;

public class CloudStream implements Stream{

    @Override
    public void write(String data) {
        System.out.println("writing... "+data);
    }
}
