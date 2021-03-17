package com.learning.change_of_responsibility;

public class Compressor extends Handler{

    public Compressor(Handler next) {
        super(next);
    }

    @Override
    public boolean do_handle(HttpRequest request) {
        System.out.println("compress");
        return false;
    }
}
