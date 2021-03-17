package com.learning.visitor;

public interface Operation {
    void apply(HeadingNode heading);
    void apply(AncherNode anchor);
}
