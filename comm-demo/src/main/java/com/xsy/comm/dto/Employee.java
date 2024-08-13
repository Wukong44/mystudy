package com.xsy.comm.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
    private String name;
    private int salary;
    private String department;
    private String sex;

    public Employee(String name, int salary, String department, String sex) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.sex = sex;
    }

}
