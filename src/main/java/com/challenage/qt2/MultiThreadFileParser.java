package com.challenage.qt2;

import java.io.*;
import java.util.concurrent.*;

public class MultiThreadFileParser {
    private static final String OUTPUT_PATH = String.format("%s%s%s", System.getProperty("user.dir"), System.getProperty("file.separator"), "output.txt");
    private static final String INPUT_PATH = MultiThreadFileParser.class.getClassLoader().getResource("input.txt").getPath();

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        new MultiThreadFileParser().run();
        System.out.println("Output file: " + OUTPUT_PATH);
    }

    private void run() throws IOException, ExecutionException, InterruptedException {
        File output = new File(OUTPUT_PATH);
        if (!output.exists()) {
            output.createNewFile();
        }

        PrintWriter writer = new PrintWriter(OUTPUT_PATH);
        writer.print("");
        writer.close();

        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() +1);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(ex);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH, true))) {
            String line;
            int index = 1;
            while ((line = bufferedReader.readLine()) != null) {
                final String _line = line;
                final int _index = index;
                completionService.submit(() -> {
                    String result = String.format("%d,%s%s", _index, ParserUtil.parseLine(_line), System.lineSeparator());
                    bufferedWriter.write(result);
                    return result;
                });
                index++;
            }
        }
        ex.shutdown();
    }
}
