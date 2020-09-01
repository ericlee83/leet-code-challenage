package com.pattern.structural.composite;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HeadDepartmentTest {

    @Test
    void printDepartmentName() {
        Department salesDepartment = new SalesDepartment(1,"Sales department");
        Department financialDepartment = new FinancialDepartment(2,"Financial department");
        Department headDepartment = HeadDepartment.builder()
                .id(3)
                .name("Head department")
                .childDepartment(salesDepartment)
                .childDepartment(financialDepartment).build();
        headDepartment.printDepartmentName();

    }
}