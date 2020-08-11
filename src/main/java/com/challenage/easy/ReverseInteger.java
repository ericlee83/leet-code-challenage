package com.challenage.easy;

public class ReverseInteger {
    public int solution(int x) {
        boolean isNegative = x<0;
        Long y = 0L;
        int last = 0;
        do {
            last = x %10;
            x = x /10;
            y = y*10+ Math.abs(last);
        }while(x!=0);
        if(y>Integer.MAX_VALUE ) {
            return 0;
        }
        if(isNegative) {
            y *=-1;
            if(y<Integer.MIN_VALUE) return 0;
        }
        return y.intValue();
    }
}
