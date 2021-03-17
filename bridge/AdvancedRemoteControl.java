package com.learning.bridge;

public class AdvancedRemoteControl extends RemoteControl{
    public AdvancedRemoteControl(Device device) {
        super(device);
    }
    public void set_channel(int number){
        device.set_channel(number);
    }
}
