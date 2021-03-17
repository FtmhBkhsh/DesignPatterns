package com.learning.change_of_responsibility;

public abstract class Handler {
    private Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public void handle(HttpRequest request) {
        //check if the handle process is done
       if(do_handle(request)) {
           System.out.println("wrong username or password");
           return;
       }
       if (next != null)
           next.handle(request);
    }
    public abstract boolean do_handle(HttpRequest request);
}
