package com.learning.strategy;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void apply(String file_name) {
        System.out.println("applying Black and white filter");
    }
}
