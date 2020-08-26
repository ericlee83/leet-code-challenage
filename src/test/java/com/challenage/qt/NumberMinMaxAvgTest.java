package com.challenage.qt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberMinMaxAvgTest {

    @Test
    void solution() {
        NumberMinMaxAvg avg = new NumberMinMaxAvg();
        avg.solution();
    }


    @Test
    void parseLine() {
        NumberMinMaxAvg avg = new NumberMinMaxAvg();
        assertEquals("1,4,2087956.25,8349348,33",avg.parseLine(1,"2323,8349348,121,33"));
        assertEquals("2,3,104525,312623,4",avg.parseLine(2,"948,4,312623"));
    }
}