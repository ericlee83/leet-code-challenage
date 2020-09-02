package com.pattern.behavioral.interpreter;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class Select implements Expression{
    private String column;
    private From from;
    @Override
    public List<String> interpret(Context ctx) {
        ctx.setColumn(column);
        return from.interpret(ctx);
    }
}
