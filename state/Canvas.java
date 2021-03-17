package com.learning.state;

public class Canvas {

    private Tool currentTool;

    public void mouse_up(){
        currentTool.mouse_up();
    }

    public void mouse_down(){
        getCurrentTool().mouse_down();
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }
}
