package com.pattern.creational.builder.withinheritance;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Parent {
    private final String parentName;
    private final int parentAge;

    public Parent(String parentName, int parentAge) {
        this.parentName = parentName;
        this.parentAge = parentAge;
    }
}
