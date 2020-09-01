package com.pattern.structural.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class SalesDepartment implements Department{
    private Integer id;
    private String name;
    @Override
    public void printDepartmentName() {
        log.info(getClass().getSimpleName());
    }
}
