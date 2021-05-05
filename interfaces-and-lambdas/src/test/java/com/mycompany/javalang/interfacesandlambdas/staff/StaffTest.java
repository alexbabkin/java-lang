package com.mycompany.javalang.interfacesandlambdas.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.mycompany.javalang.interfacesandlambdas.measurable.Measurable;
import com.mycompany.javalang.interfacesandlambdas.measurable.impl.Employee;
import org.junit.Test;

public class StaffTest {
    @Test
    public void getAverageTest_NoUsers() {
        Staff staff = new Staff();

        double avg = staff.getAverage();
        assertEquals(0.0, avg, 0.0);
    }

    @Test
    public void getAverageTest_OneUser() {
        Staff staff = new Staff();

        Employee e = new Employee("Person 1", 1000.5);
        staff.addPerson(e);

        double avg = staff.getAverage();
        assertEquals(1000.5, avg, 0.0);
    }

    @Test
    public void getAverageTest_SeveralUsers_SameValue() {
        Staff staff = new Staff();

        Employee e = new Employee("Person 1", 1000.5);
        staff.addPerson(e);
        e = new Employee("Person 2", 1000.5);
        staff.addPerson(e);
        e = new Employee("Person 3", 1000.5);
        staff.addPerson(e);

        double avg = staff.getAverage();
        assertEquals(1000.5, avg, 0.0);
    }

    @Test
    public void getAverageTest_SeveralUsers_DiffValues() {
        Staff staff = new Staff();

        Employee e = new Employee("Person 1", 1000.5);
        staff.addPerson(e);
        e = new Employee("Person 2", 2000.5);
        staff.addPerson(e);
        e = new Employee("Person 3", 3000.5);
        staff.addPerson(e);

        double avg = staff.getAverage();
        assertEquals(2000.5, avg, 0.0);
    }

    @Test
    public void getLargestTest_SeveralUsers() {
        Staff staff = new Staff();

        Employee e = new Employee("Person 1", 1000.5);
        staff.addPerson(e);
        e = new Employee("Person 2", 5000.5);
        staff.addPerson(e);
        e = new Employee("Person 3", 3000.5);
        staff.addPerson(e);

        Measurable largest = staff.getLargest();
        assertEquals("Person 2", ((Employee) largest).getName());
    }

    @Test
    public void getLargestTest_NolUsers() {
        Staff staff = new Staff();

        Measurable largest = staff.getLargest();
        assertNull(largest);
    }
}
