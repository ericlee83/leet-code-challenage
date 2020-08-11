package com.challenage.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {


    @Test
    void solution() {
        ReverseInteger reverseInteger = new ReverseInteger();
        assertEquals(54321,reverseInteger.solution(12345));
        assertEquals(-54321,reverseInteger.solution(-12345));
    }
}