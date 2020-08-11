package com.challenage.medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int solution(String s){
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        int lengthOfString = s.length();
        for(int left =0,right=0;right<lengthOfString;right++) {
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)),left);
            }
            maxLength = Math.max(maxLength, right - left +1);
            map.put(s.charAt(right), right+1);
        }
        return maxLength;
    }
}
