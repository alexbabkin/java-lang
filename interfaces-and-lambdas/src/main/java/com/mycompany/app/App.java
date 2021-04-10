package com.mycompany.app;

import com.mycompany.measurable.Measurable;
import com.mycompany.measurable.impl.Employee;
import com.mycompany.staff.Staff;
import com.mycompany.intsequence.IntSequence;
import com.mycompany.sorter.Sorter;

public class App 
{
    public static void main( String[] args )
    {
        IntSequence seq = IntSequence.of(1, 2, 3, 4, 5);
        while(seq.hasNext()) {
            System.out.println(seq.next());
        }
    }
}
