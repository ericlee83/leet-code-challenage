package com.pattern.behavioral.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFileOperationExecutorTest {
    @Test
    void execute() {
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        TextFile textFile = new TextFile("input.txt");
        executor.executeOperation(new OpenTextFileOperation(textFile));
        executor.executeOperation(new SaveTextFileOperation(textFile));
    }

    @Test
    void executeOperation_without_operation_impl() {
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        TextFile textFile = new TextFile("input.txt");
        executor.executeOperation(textFile::open);
        executor.executeOperation(textFile::save);
    }

    @Test
    void executeOperation_with_lambda() {
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        executor.executeOperation(() -> "Open file");
        executor.executeOperation(() -> "Save file");
    }
}