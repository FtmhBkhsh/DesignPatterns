package com.learning.state;

public class BrushTool implements Tool{
    @Override
    public void mouse_up() {
    System.out.println("brush icon");
    }

    @Override
    public void mouse_down() {
    System.out.println("draw a line");
    }
}
