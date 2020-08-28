package com.challenage.qt2;

import java.text.DecimalFormat;

public class ParserUtil {
    private static DecimalFormat df = new DecimalFormat("#.##");
    public static String parseLine(String line) {
        double avg = 0.00;
        int v = 0;
        int count = 1;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (String num : line.split(",")) {
            v = Integer.parseInt(num);
            min = v < min ? v : min;
            max = v > max ? v : max;
            avg = avg - (avg - v) / count++;
        }
        return String.format("%d,%s,%d,%d", count - 1, df.format(avg), max, min);
    }
}
