package om.mycompany.javalang.interfacesandlambdas.measurable.impl;

import om.mycompany.javalang.interfacesandlambdas.measurable.Measurable;

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