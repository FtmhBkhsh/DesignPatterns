package com.learning.iterator;

import com.learning.memento.EditorState;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {


    private List<String> urls = new ArrayList<>();

    public void push(String url){
        urls.add(url);
    }

    public String pop(){
        var last_index = urls.size()-1;
        var last_url = urls.get(last_index);
        urls.remove(last_url);
        return last_url;

    }

    public Iterator create_iterator(){
        return new List_iterator(this);
    }

    public  class List_iterator implements Iterator{
        private BrowseHistory history;
        private int index;
        public  List_iterator(BrowseHistory history){
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return (index<history.urls.size());
        }

        @Override
        public String current() {
            return history.urls.get(index);
        }

        @Override
        public void next() {
        index++;
        }
    }
}
