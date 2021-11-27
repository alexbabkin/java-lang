package com.github.alexbabkin.javalang.interfaces.measurable.impl;

import com.github.alexbabkin.javalang.interfaces.measurable.Measurable;

public class Employee implements Measurable {
    private final double salary;
    private final String name;

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
