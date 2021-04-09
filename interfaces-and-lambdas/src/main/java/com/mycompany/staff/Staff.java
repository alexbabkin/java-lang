package com.mycompany.staff;

import com.mycompany.measurable.Measurable;
import com.mycompany.measurable.impl.Employee;
import java.util.List;
import java.util.ArrayList;

public class Staff {
    private List<Measurable> persons;

    public Staff() {
        persons = new ArrayList();
    }

    public void addPerson(Employee e) {
        persons.add(e);
    }

    public double getAverage() {
        double sum = 0.0;
        for(Measurable person : persons) {
            sum += person.getMeasure();
        }

        return sum / persons.size();
    }

    public Measurable getLargest() {
        Measurable largest = null;
        for(Measurable person : persons) {
            if (largest == null || person.getMeasure() > largest.getMeasure()) {
                largest = person;
            }
        }
        return largest;
    }
}