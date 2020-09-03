package com.pattern.behavioral.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @Test
    void test_standard_computer_builder(){
        new StandardComputerBuilder()
                .buildComputer()
                .getComputerParts()
                .forEach((k,v) -> System.out.println("Part : "+k+" Value : "+v));
    }
}