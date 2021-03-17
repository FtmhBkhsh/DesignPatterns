package com.learning.visitor;

public class HighlightingOperation implements Operation{
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("heading was highlighted");
    }

    @Override
    public void apply(AncherNode anchor) {
        System.out.println("anchor was highlighted");
    }
}
