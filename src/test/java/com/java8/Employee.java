package com.java8;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Employee {
    Long id;
    String name;
    Double salary;
}
