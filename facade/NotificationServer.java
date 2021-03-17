package com.learning.facade;

public class NotificationServer {

    public Connection connect(String ip_address){
        return new Connection();
    }
    public AuthToken authenticate(String app_id,String key){
        return new AuthToken();
    }
    public void send(AuthToken auth_token,Message message,String target){
        System.out.println("Sending a message");
    }
}
