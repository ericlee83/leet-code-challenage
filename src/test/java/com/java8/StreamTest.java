package com.java8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {

    private static List<Employee> empList;

    @BeforeAll
    static void beforeAll() {
        empList = Stream.of(
                Employee.builder().id(1L).name("Bill Gates").salary(600000.0).build(),
                Employee.builder().id(2L).name("Jeff Bezos").salary(300000.0).build(),
                Employee.builder().id(3L).name("Mark Zuckerberg").salary(200000.0).build()
        ).collect(Collectors.toList());
    }

    @Test
    void SummarizingDouble() {
        DoubleSummaryStatistics stats = DoubleStream.iterate(1, v -> v * 2)
                .limit(10)
                .boxed()
                .collect(Collectors.summarizingDouble(Double::doubleValue));
        assertEquals(stats.getAverage(), 102.3, 0);
        assertEquals(stats.getMin(), 1, 0);
        assertEquals(stats.getMax(), 512, 0);
        assertEquals(stats.getSum(), 1023, 0);
    }

    @Test
    public void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));

        assertEquals(isEven.get(true).size(), 4);
        assertEquals(isEven.get(false).size(), 1);
    }

    @Test
    public void whenStreamMapping_thenGetMap() {
        Map<Character, List<Long>> idGroupedByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> Character.valueOf(e.getName().charAt(0)),
                        Collectors.mapping(Employee::getId, Collectors.toList())));

        assertEquals(idGroupedByAlphabet.get('B').get(0), 1L);
        assertEquals(idGroupedByAlphabet.get('J').get(0), 2L);
        assertEquals(idGroupedByAlphabet.get('M').get(0), 3L);
    }

    @Test
    public void whenStreamGroupingBy_thenGetMap() {
        Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e->Character.valueOf(e.getName().charAt(0))));

        assertEquals(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
        assertEquals(groupByAlphabet.get('J').get(0).getName(), "Jeff Bezos");
        assertEquals(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");
    }
}
