package com.learning.change_of_responsibility;

public class Authenticator extends Handler{

    public Authenticator(Handler next) {
        super(next);
    }

    @Override
    public boolean do_handle(HttpRequest request) {
        var is_valid = (request.getUser_name()=="admin"&&
                request.getPassword() =="1234");
        System.out.println("Authentication");
        return !is_valid;
    }
}
