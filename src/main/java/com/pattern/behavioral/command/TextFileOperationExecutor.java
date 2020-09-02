package com.pattern.behavioral.command;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TextFileOperationExecutor {
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation){
        textFileOperations.add(textFileOperation);
        log.info(textFileOperations.size()+": "+textFileOperation.getClass().getSimpleName());
        return textFileOperation.execute();
    }
}
