package com.pattern.creational.builder.withinheritance;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Student extends Child{
    private final String schoolName;

    public Student(String parentName, int parentAge, String childName, int childAge, String schoolName) {
        super(parentName, parentAge, childName, childAge);
        this.schoolName = schoolName;
    }
}
