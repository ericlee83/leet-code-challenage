package com.pattern.behavioral.visitor;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ElementVisitorTest {
    @Test
    void test(){
        Visitor v = new ElementVisitor();

        Document d = new Document(UUID.randomUUID().toString());
        d.elements.add(new JsonElement(UUID.randomUUID().toString()));
        d.elements.add(new JsonElement(UUID.randomUUID().toString()));
        d.elements.add(new XmlElement(UUID.randomUUID().toString()));

        d.accept(v);
    }
}