package com.pattern.behavioral.interpreter;

import java.util.List;

public interface Expression {
    List<String> interpret(Context ctx);
}
