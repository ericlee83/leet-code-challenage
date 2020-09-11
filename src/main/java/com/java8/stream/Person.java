package com.java8.stream;

import lombok.Data;

@Data
public class Person {
    private int age;
    private String name;
    private String email;

    public Person(int age, String name, String email) {
        this.age = age;
        this.name = name;
        this.email = email;
    }
}
