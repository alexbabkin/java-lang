package com.github.alexbabkin.javalang.classesandreflection;

import com.github.alexbabkin.javalang.classesandreflection.point.Point;
import com.github.alexbabkin.javalang.classesandreflection.reflection.Stringifier;
import com.github.alexbabkin.javalang.classesandreflection.shape.Line;

public class App {
    public static void main(String[] args) {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        try {
            System.out.println(Stringifier.toString(line));
        } catch (IllegalAccessException ex) {
            System.out.println(ex);
        }
    }
}
