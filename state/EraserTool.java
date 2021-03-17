package com.learning.state;

public class EraserTool implements Tool{
    @Override
    public void mouse_up() {
        System.out.println("eraser icon");
    }

    @Override
    public void mouse_down() {
        System.out.println("erase something");
    }
}
