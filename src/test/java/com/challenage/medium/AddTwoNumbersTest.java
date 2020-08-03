package com.challenage.medium;

import com.challenage.domain.ListNode;
import com.challenage.domain.ListNodeBuilder;
import com.util.annotation.rangesrouce.RangeSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    private ListNode l1;
    private ListNode l2;
    private AddTwoNumbers addTwoNumbers;

    @BeforeEach
    void setUp() {
        l1 = ListNodeBuilder
                .createListNodeAndGetFirstNode(new int[]{2,4,3});
        l2 = ListNodeBuilder
                .createListNodeAndGetFirstNode(new int[]{5,6,4});
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    void solutionTest(){
        ListNode firstNode = addTwoNumbers.solution(l1,l2);
        assertEquals("7->0->8",ListNodeBuilder.toString(firstNode));
    }

    @ParameterizedTest
    @RangeSource(min = 24, max = 200, step = 8)
    void dividedBy16(int i){
        assertEquals(0, i%16);
    }
}