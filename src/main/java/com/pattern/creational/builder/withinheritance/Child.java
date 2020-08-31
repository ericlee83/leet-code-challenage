package com.pattern.creational.builder.withinheritance;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Child extends Parent{

    private final String childName;
    private final int childAge;

    public Child(String parentName, int parentAge,String childName,int childAge) {
        super(parentName, parentAge);
        this.childName = childName;
        this.childAge = childAge;
    }
}
