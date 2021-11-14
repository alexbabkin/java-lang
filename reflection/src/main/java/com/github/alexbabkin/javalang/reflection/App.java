package com.github.alexbabkin.javalang.reflection;

import com.github.alexbabkin.javalang.classes.point.Point;
import com.github.alexbabkin.javalang.classes.shape.Line;
import com.github.alexbabkin.javalang.reflection.stringifier.Stringifier;

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
