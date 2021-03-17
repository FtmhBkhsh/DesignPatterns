package com.learning.strategy;

public class ImageStorage {
    private Compressor compressor;
    private Filter filter;
    public void store(String file_name,Compressor compressor, Filter filter){
        compressor.compress(file_name);
        filter.apply(file_name);
    }
}
