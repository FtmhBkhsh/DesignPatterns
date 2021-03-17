package com.learning.bridge;

public class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turn_on(){
        device.turn_on();
    }

    public void turn_off(){
        device.turn_off();
    }
}
