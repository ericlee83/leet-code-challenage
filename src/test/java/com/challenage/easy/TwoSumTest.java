package com.challenage.easy;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSumTest(){
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.solution(nums,target);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new int[]{0,1},result);
    }
}