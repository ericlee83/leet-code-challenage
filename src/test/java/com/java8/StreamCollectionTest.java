package com.java8;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

public class StreamCollectionTest {

    private static List<String> givenList;

    @BeforeEach
    void init() {
        givenList = Arrays.asList("a", "bb", "ccc", "dd");
    }

    @Test
    void collectingAndThenTest(){
        final List<String> result = givenList.stream().collect(collectingAndThen(toList(), ImmutableList::copyOf));
        assertTrue(result instanceof ImmutableList,"result should be an immutable List");
    }

    @Test
    void joinTest(){
        String result = givenList.stream()
                .collect(joining(" ", "PRE-", "-POST"));
        assertEquals("PRE-a bb ccc dd-POST",result);
    }

    @Test
    void countingTest(){
        Long count = givenList.stream().collect(counting());
        assertEquals(4L, count,0);
    }

    @Test
    void summaryStatisticsTest(){
        DoubleSummaryStatistics statistics = givenList.stream().collect(summarizingDouble(String::length));
        assertAll("test summarize static",
                ()-> assertEquals(statistics.getAverage(),2,0),
                ()-> assertEquals(statistics.getCount(),4),
                ()-> assertEquals(statistics.getMax(),3,0),
                ()-> assertEquals(statistics.getMin(),1,0),
                ()-> assertEquals(statistics.getSum(),8,0));
    }

    @Test
    void averagingDoubleTest(){
        Double result = givenList.stream()
                .collect(averagingDouble(String::length));
        assertEquals(2d,result,0);
    }

    @Test
    void maxByTest(){
        Optional<String> max = givenList.stream().collect(maxBy(Comparator.naturalOrder()));
        assertEquals("dd",max.orElse(""));
    }

    @Test
    void groupingByTest(){
        Map<Integer, Set<String>> result = givenList.stream()
                .collect(groupingBy(String::length, toSet()));
        assertEquals(result.get(1), ImmutableSet.of("a"));
    }

    @Test
    void partitioningByTest(){
        Map<Boolean,List<String>> result = givenList.stream().collect(partitioningBy(s->s.length()>2));
        assertEquals(result.get(true),ImmutableList.of("ccc"));
    }

    @Test
    void teesTest(){
        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
        List<Integer> result = numbers.stream().collect(teeing(
                minBy(Integer::compareTo),
                maxBy(Integer::compareTo),
                (min,max)-> ImmutableList.of(min.orElse(null),max.orElse(null))
        ));
        assertEquals(result.get(0),2);
        assertEquals(result.get(1),42);
    }
}
