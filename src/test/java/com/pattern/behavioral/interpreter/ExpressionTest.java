package com.pattern.behavioral.interpreter;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

    @Test
    void test(){
        Expression query = new Select("name", new From("people"));
        Context ctx = new Context();
        List<String> result = query.interpret(ctx);
        System.out.println(result);

        Expression query2 = new Select("*", new From("people"));
        List<String> result2 = query2.interpret(ctx);
        System.out.println(result2);

        Expression query3 = new Select("name",
                new From("people",
                        new Where(name -> name.toLowerCase().startsWith("d"))));
        List<String> result3 = query3.interpret(ctx);
        System.out.println(result3);

        Expression query4 = new Select("job",
                new From("people",
                        new Where(job -> job.equalsIgnoreCase("Developer"))));
        List<String> result4 = query4.interpret(ctx);
        System.out.println(result4);

    }
}