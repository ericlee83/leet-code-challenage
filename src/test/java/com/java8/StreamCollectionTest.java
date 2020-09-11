package com.java8;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.java8.stream.BlogPost;
import com.java8.stream.BlogPostType;
import com.java8.stream.FunctionUtils;
import com.java8.stream.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
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

    @Test
    void compareIntTest(){
        List<BlogPost> posts = Arrays.asList( new BlogPost("java","Erich", BlogPostType.GUIDE,100),
                new BlogPost("sql","Erich", BlogPostType.NEWS,101),
                new BlogPost("spring","Erich", BlogPostType.GUIDE,102));
        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        maxBy(comparingInt(BlogPost::getLikes))));
        assertEquals(maxLikesPerPostType.get(BlogPostType.GUIDE).map(BlogPost::getLikes).orElse(0),102);
    }

    @Test
    void modifyReturnMap(){
        List<BlogPost> posts = Arrays.asList( new BlogPost("java","Erich", BlogPostType.GUIDE,100),
                new BlogPost("sql","Erich", BlogPostType.NEWS,101),
                new BlogPost("spring","Erich", BlogPostType.GUIDE,102));
        EnumMap<BlogPostType,List<BlogPost>> result = posts.stream().collect(groupingBy(BlogPost::getType,
                ()-> new EnumMap<>(BlogPostType.class),
                toList()));
    }

    @Test
    void filterOutEmpty(){
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

        List<String> filteredList = listOfOptionals.stream()
                .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());

        List<String> filteredListJava9 = listOfOptionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        assertEquals(2,filteredList.size());
        assertEquals(2,filteredListJava9.size());
    }

    @Test
    void DistinctTest(){
        List<Person> personList = Stream.of(new Person(36,"Erich","Lam@Lam.com"),
                new Person(36,"Eric","am@Lam.com"),new Person(36,"Erich","m@Lam.com")).collect(toList());
        List<Person> personListFiltered = personList.stream()
                .filter(FunctionUtils.distinctByKey(p -> p.getName()))
                .collect(Collectors.toList());
        assertEquals(2, personListFiltered.size());
    }




}
