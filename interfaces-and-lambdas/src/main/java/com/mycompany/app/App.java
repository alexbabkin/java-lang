package com.mycompany.app;

import com.mycompany.measurable.Measurable;
import com.mycompany.measurable.impl.Employee;
import com.mycompany.staff.Staff;

public class App 
{
    public static void main( String[] args )
    {
        Staff staff = new Staff();
        for(int i = 1; i < 10; i++) {
            Employee e = new Employee("Person " + i, i * 1000.5);
            staff.addPerson(e);
        }

        double average = staff.getAverage();
        System.out.println("Average salary is " + average);
        Measurable e = staff.getLargest();
        if (e instanceof Employee) {
            System.out.println(((Employee)e).getName() + " has the largest salary");
        }
    }
}
