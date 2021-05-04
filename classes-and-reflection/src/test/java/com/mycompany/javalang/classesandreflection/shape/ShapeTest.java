package com.mycompany.javalang.classesandreflection.shape;

import java.lang.Throwable;
import java.lang.IllegalArgumentException;

import com.mycompany.javalang.classesandreflection.point.Point;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;



public class ShapeTest {
    private Shape getShape(Point center) {
        return new Shape(center) {
            @Override
            public void moveElementsBy(double x, double y) {
                ;
            }
        };
    }

    @Test
    public void createShape_NullCenterException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> getShape(null));
        assertEquals("Ceneter must not be null", exception.getMessage());
    }

    @Test
    public void getCenterTest() {
        Point center = new Point(0.0, 0.0);
        Shape shape = getShape(center);

        assertEquals(center, shape.getCenter());
    }

    @Test
    public void moveByTest() {
        Point center = new Point(0.0, 0.0);
        Shape shape = getShape(center);

        shape.moveBy(1.0, 2.0);

        assertEquals(new Point(1.0, 2.0), shape.getCenter());
    }

    @Test
    public void equalsTest_equals() {
        Point center1 = new Point(1.0, 2.0);
        Point center2 = new Point(1.0, 2.0);

        Shape shape1 = getShape(center1);
        Shape shape2 = getShape(center2);

        assertEquals(true, shape1.equals(shape2));
        assertEquals(true, shape2.equals(shape1));
    }

    @Test
    public void equalsTest_notEquals() {
        Point center1 = new Point(1.0, 2.0);
        Point center2 = new Point(3.0, 4.0);

        Shape shape1 = getShape(center1);
        Shape shape2 = getShape(center2);

        assertEquals(false, shape1.equals(null));
        assertEquals(false, shape2.equals(center1));
        assertEquals(false, shape1.equals(shape2));
    }

    @Test
    public void toStringTest() {
        Point center = new Point(1.0, 2.0);
        assertEquals(" center: (x = 1.0, y = 2.0)" , getShape(center).toString());
    }

    public void cloneTest() {
        Point center = new Point(0.0, 0.0);
        Shape shape = getShape(center);
        Shape cloned = null;
        try {
            cloned = shape.clone();
        } catch (CloneNotSupportedException ex) {
            ;
        }
        assertEquals(true, shape.equals(cloned));
        
        shape.moveBy(1, 2);
        assertEquals(false, shape.equals(cloned));
    }
}