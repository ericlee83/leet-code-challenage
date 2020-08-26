package com.challenage.qt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberMinMaxAvg {
    private static DecimalFormat df = new DecimalFormat("#.##");
    public void solution(){
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("input.txt")){
            Scanner sc = new Scanner(inputStream, "UTF-8");
            int lineNumber = 1;
            while (sc.hasNextLine()) {
                System.out.println(String.format("%d,%s",lineNumber++,parseLine(sc.nextLine())));
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void solutionParallel() throws IOException {
        URL url = getClass().getClassLoader().getResource("input.txt");
        final List<String> lines = Files.readAllLines(Paths.get(url.getPath()));
        IntStream.range(0,lines.size())
                .mapToObj(index->String.format("%d;%s",index+1,lines.get(index)))
                .parallel()
                .map(line->parseLineParallel(line))
                .peek(System.out::println)
                .collect(Collectors.toList());

    }

    public String parseLineParallel(String line){
        String[] info = line.split(";");
        return String.format("%s,%s",info[0],parseLine(info[1]));
    }


    public String parseLine(String line){
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
        return String.format("%d,%s,%d,%d",count-1,df.format(avg),max,min);
    }
}
