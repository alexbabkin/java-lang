package com.mycompany.measurable.impl;

import com.mycompany.measurable.Measurable;

public class Employee implements Measurable {
    private double salary;
    private String name;
    
    public Employee(String name, double salary) {
        this.salary = salary;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }
}