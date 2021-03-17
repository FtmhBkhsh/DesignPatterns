package com.learning.change_of_responsibility;

public class Logger extends Handler{


    public Logger(Handler next) {
        super(next);
    }

    @Override
    public boolean do_handle(HttpRequest request) {
        System.out.println("log");
        return false;
    }
}
