package com.learning.proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String,Ebook> ebooks = new HashMap<>();

    public void add(Ebook ebook){
        ebooks.put(ebook.get_file_name(),ebook);
    }
    public void open_ebook(String file_name) {
        ebooks.get(file_name).show();
    }
}
