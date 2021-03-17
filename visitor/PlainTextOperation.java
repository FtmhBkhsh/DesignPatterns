package com.learning.visitor;

public class PlainTextOperation implements Operation{
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("heading text");
    }

    @Override
    public void apply(AncherNode anchor) {
        System.out.println("anchor text");
    }
}
