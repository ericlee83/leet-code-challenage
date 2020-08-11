package com.challenage.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] solution(int[] nums, int target) {
        for(int i = 0 ; i < nums.length-1 ;i ++ ){
            for(int j = i +1; j < nums.length ; j ++){
                if(nums[i]+nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{};
    }

    public int[] solutionTwo(int[] nums, int target){
        Map<Integer,Integer> calMap = new HashMap<>();
        for(int i = 0; i < nums.length;i ++){
            if(calMap.containsKey(nums[i])){
                return new int[]{calMap.get(nums[i]),i};
            }else{
                calMap.put(target-nums[i],i);
            }
        }
        return new int[]{};
    }
}
