package com.pattern.behavioral.visitor;

public interface Visitor {
    void visit(XmlElement xe);

    void visit(JsonElement je);
}
