package com.challenage.easy;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfIntegerStreamTest {

    @Test
    void getMedian() {
        MedianOfIntegerStream stream = new MedianOfIntegerStream();
        IntStream.range(1,100).forEach(stream::add);
        assertEquals(50d,stream.getMedian(),0);
    }
}