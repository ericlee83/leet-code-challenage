package com.pattern.structural.composite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@AllArgsConstructor
@Builder
public class HeadDepartment implements Department{
    private Integer id;
    private String name;

    @Singular private List<Department> childDepartments;

    @Override
    public void printDepartmentName() {
        childDepartments.forEach(Department::printDepartmentName);
    }
}
