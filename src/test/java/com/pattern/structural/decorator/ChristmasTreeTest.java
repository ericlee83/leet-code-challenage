package com.pattern.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasTreeTest {

    @Test
    void testDecorator(){
        ChristmasTree tree = new BubbleLights(new ChristmasTreeImpl());
        assertEquals("Christmas tree with Bubble Lights",tree.decorate());
    }

}