package com.learning.adaptor;

public class VividFilter implements Filter{
    @Override
    public void apply(Image image) {
        System.out.println("Applying vivid filter");
    }
}
