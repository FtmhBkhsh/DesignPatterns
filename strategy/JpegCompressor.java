package com.learning.strategy;

public class JpegCompressor implements Compressor {

    @Override
    public void compress(String file_name) {
        System.out.println("compressing using jpeg");
    }
}
