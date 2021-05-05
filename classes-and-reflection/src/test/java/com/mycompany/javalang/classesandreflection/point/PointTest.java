package com.mycompany.javalang.classesandreflection.point;

import java.lang.CloneNotSupportedException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PointTest {
    @Test
    public void getXTest() {
        Point point = new Point(1.0, 2.0);

        assertEquals(1.0, point.getX(), 0.0);
    }

    @Test
    public void getYTest() {
        Point point = new Point(1.0, 2.0);

        assertEquals(2.0, point.getY(), 0.0);
    }

    @Test
    public void moveByTest() {
        Point point = new Point(1.0, 2.0);
        point.moveBy(2.0, 3.0);

        assertEquals(3.0, point.getX(), 0.0);
        assertEquals(5.0, point.getY(), 0.0);
    }

    @Test
    public void equalsTest_equals() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(1.0, 2.0);

        assertEquals(true, point1.equals(point2));
        assertEquals(true, point2.equals(point1));
        assertEquals(true, point1.equals(point1));
    }

    @Test
    public void equalsTest_notEquals() {
        Point point1 = new Point(1.0, 2.0);

        assertEquals(false, point1.equals(null));
        assertEquals(false, point1.equals(new Point(2.0, 2.0)));
        assertEquals(false, point1.equals(new Point(1.0, 3.0)));
    }

    @Test
    public void toStringTest() {
        assertEquals("Point: x = 1.1, y = 2.2", (new Point(1.1, 2.2)).toString());
    }

    @Test
    public void cloneTest() {
        Point point = new Point(1.0, 2.0);
        Point cloned = null;
        try {
            cloned = point.clone();
        } catch (CloneNotSupportedException ex) {
            ;
        }
        assertEquals(true, point.equals(cloned));
        
        point.moveBy(1, 2);
        assertEquals(false, point.equals(cloned));
    }
}