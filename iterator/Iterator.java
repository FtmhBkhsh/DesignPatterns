package com.learning.iterator;

public interface Iterator  {
    boolean hasNext();
    String current();
    void next();
}

//implements Iterator<String>
//implements Iterator<User>