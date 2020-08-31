package com.pattern.structural.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpensiveObjectProxyTest {

    @Test
    void process() {
        ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}