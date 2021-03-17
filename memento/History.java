package com.learning.memento;

import java.util.ArrayList;
import java.util.List;

public class History {

    private List<EditorState> states = new ArrayList<>();

    public void push(EditorState state){
        states.add(state);
    }

    public EditorState pop(){
        var last_index = states.size()-1;
        var last_state = states.get(last_index);
        states.remove(last_state);
        return last_state;

    }
}
