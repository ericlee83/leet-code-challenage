package com.challenage.qt;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class NumberMinMaxAvg {
    private static DecimalFormat df = new DecimalFormat("#.##");
    public void solution(){
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("input.txt")){
            Scanner sc = new Scanner(inputStream, "UTF-8");
            int lineNumber = 1;
            while (sc.hasNextLine()) {
                String result = parseLine(lineNumber++,sc.nextLine());
                System.out.println(result);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String parseLine(int lineNumber, String line){
        double avg = 0.00;
        int v = 0;
        int count = 1;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(String num: line.split(",")){
            v = Integer.parseInt(num);
            min = v<min?v:min;
            max = v>max?v:max;
            avg = avg - (avg - v)/ count++;
        }
        return String.format("%d,%d,%s,%d,%d",lineNumber,count-1,df.format(avg),max,min);
    }
}
