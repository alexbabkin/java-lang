package com.mycompany.javalang.classesandreflection;

import java.lang.CloneNotSupportedException;

import com.mycompany.javalang.classesandreflection.shape.Line;
import com.mycompany.javalang.classesandreflection.point.Point;

public class App {
    public static void main( String[] args ) {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        try {
            line.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }
    }
}
