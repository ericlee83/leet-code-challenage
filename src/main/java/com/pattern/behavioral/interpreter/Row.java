package com.pattern.behavioral.interpreter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Row {
    private String name;
    private String surname;
    private String job;

    @Override
    public String toString() {
        return name + " " + surname+ " " +job;
    }
}
