package com.github.alexbabkin.javalang.reflection.stringifier;

import static org.junit.Assert.assertEquals;

import com.github.alexbabkin.javalang.classes.point.Point;
import com.github.alexbabkin.javalang.classes.shape.Line;
import org.junit.Test;

public class StringifierTest {
    @Test
    public void toStringTest() throws IllegalAccessException {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        String result = Stringifier.toString(line);
        assertEquals(
                "Line: {"
                        + "from(Point) = {x(double) = 1.0, y(double) = 1.0}, "
                        + "to(Point) = {x(double) = 2.0, y(double) = 2.0}, "
                        + "center(Point) = {x(double) = 1.5, y(double) = 1.5}"
                        + "}",
                result);
    }
}
