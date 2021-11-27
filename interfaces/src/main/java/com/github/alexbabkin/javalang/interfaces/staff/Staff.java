package com.github.alexbabkin.javalang.interfaces.staff;

import com.github.alexbabkin.javalang.interfaces.measurable.Measurable;
import com.github.alexbabkin.javalang.interfaces.measurable.impl.Employee;
import java.util.ArrayList;
import java.util.List;

public class Staff {
    private final List<Measurable> persons;

    public Staff() {
        persons = new ArrayList<>();
    }

    public void addPerson(Employee e) {
        persons.add(e);
    }

    public double getAverage() {
        double sum = 0.0;
        if (persons.size() == 0) {
            return sum;
        }
        for (Measurable person : persons) {
            sum += person.getMeasure();
        }

        return sum / persons.size();
    }

    public Measurable getLargest() {
        Measurable largest = null;
        for (Measurable person : persons) {
            if (largest == null || person.getMeasure() > largest.getMeasure()) {
                largest = person;
            }
        }
        return largest;
    }
}
