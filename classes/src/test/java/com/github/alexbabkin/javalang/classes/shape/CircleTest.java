package com.github.alexbabkin.javalang.classes.shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.github.alexbabkin.javalang.classes.point.Point;
import org.junit.Test;

public class CircleTest {
    @Test
    public void getCenterTest() {
        Point center = new Point(1.0, 2.0);

        Circle circle = new Circle(center, 10.0);

        assertEquals(center, circle.getCenter());
    }

    @Test
    public void getHeightTest() {
        Point center = new Point(1.0, 2.0);

        Circle circle = new Circle(center, 10.0);

        assertEquals(10.0, circle.getRadius(), 0.0);
    }

    @Test
    public void moveElementsByTest() {
        Point center = new Point(1.0, 2.0);

        Circle circle = new Circle(center, 10.0);
        circle.moveBy(3.0, 5.0);

        Point newCenter = circle.getCenter();

        assertEquals(new Point(4.0, 7.0), newCenter);
    }

    @Test
    public void equalsTest_equals() {
        Point center = new Point(1.0, 2.0);

        Circle circle1 = new Circle(center, 10.0);
        Circle circle2 = new Circle(center, 10.0);

        assertEquals(circle1, circle2);
        assertEquals(circle2, circle1);
        assertEquals(circle1, circle1);
    }

    @Test
    public void equalsTest_notEquals() {
        Point center1 = new Point(1.0, 2.0);
        Point center2 = new Point(3.0, 4.0);

        Circle circle1 = new Circle(center1, 10.0);
        Circle circle2 = new Circle(center2, 10.0);
        Circle circle3 = new Circle(center1, 9.0);

        assertNotEquals(null, circle1);
        assertNotEquals(circle1, center1);
        assertNotEquals(circle1, circle2);
        assertNotEquals(circle1, circle3);
    }

    @Test
    public void toStringTest() {
        Point center = new Point(1.0, 2.0);
        Circle circle = new Circle(center, 10.0);

        assertEquals("Circle center: (x = 1.0, y = 2.0); radius = 10.0", circle.toString());
    }

    @Test
    public void cloneTest() {
        Point center = new Point(1.0, 2.0);
        Circle circle = new Circle(center, 10.0);

        Circle cloned = null;
        try {
            cloned = circle.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        assertEquals(circle, cloned);

        circle.moveBy(1, 2);
        assertNotEquals(circle, cloned);
    }
}
