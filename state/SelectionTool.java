package com.learning.state;

public class SelectionTool implements Tool{
    @Override
    public void mouse_up() {
    System.out.println("selection icon");
    }

    @Override
    public void mouse_down() {
    System.out.println("draw a dashed rectangle");
    }
}
