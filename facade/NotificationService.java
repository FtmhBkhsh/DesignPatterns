package com.learning.facade;

public class NotificationService {
    public void send(String message,String target){
    var server = new NotificationServer();
    var connection = server.connect("192.168.1.34");
    var auth_token = server.authenticate("app_id","app_key");
    server.send(auth_token, new Message(message),target);
    connection.disconnect();
    }
}
