package com.challenage.qt;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
            List<String> result = new ArrayList<>();
            while (sc.hasNextLine()) {
                result.add(String.format("%d,%s",lineNumber++,parseLine(sc.nextLine())));
            }
            sc.close();
            writeRaw(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void solutionParallel() throws IOException {
        URL url = getClass().getClassLoader().getResource("input.txt");
        final List<String> lines = Files.readAllLines(Paths.get(url.getPath()));
        writeRaw(IntStream.range(0,lines.size())
                .mapToObj(index->String.format("%d;%s",index+1,lines.get(index)))
                .parallel()
                .map(line->parseLineParallel(line))
                .collect(Collectors.toList()));
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

    private static void writeRaw(List<String> records) throws IOException {
        File file = File.createTempFile("output", ".txt");
        System.out.println("File: "+file.getAbsolutePath());
        try(FileWriter writer = new FileWriter(file)){
            write(records, writer);
        }
    }

    private static void write(List<String> records, Writer writer) throws IOException {
        long start = System.currentTimeMillis();
        for (String record: records) {
            writer.write(String.format("%s%s",record,System.lineSeparator()));
        }
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds");
    }

}
