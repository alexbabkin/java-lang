package com.mycompany.javalang.classesandreflection.shape;

import java.lang.Throwable;
import java.lang.CloneNotSupportedException;
import java.lang.IllegalArgumentException;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;

import com.mycompany.javalang.classesandreflection.point.Point;

public class LineTest {
    @Test
    public void createLine_NullParametersException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Line(null, new Point(1, 2)));
        assertEquals("from and to must not be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Line(new Point(1, 2), null));
        assertEquals("from and to must not be null", exception.getMessage());
    }

    @Test
    public void getFromTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        assertEquals(true, line.getFrom().equals(pointFrom));
    }

    @Test
    public void getToTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        assertEquals(true, line.getTo().equals(pointTo));
    }

    @Test
    public void calcCenterTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 3.0);

        Line line = new Line(pointFrom, pointTo);

        assertEquals(true, line.getCenter().equals(new Point(1.5, 2.5)));
    }

    @Test
    public void moveElementsByTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        line.moveElementsBy(3.0, 5.0);

        Point newPointTo = line.getTo();
        Point newPointFrom = line.getFrom();

        assertEquals(true, newPointTo.equals(new Point(4.0, 7.0)));
        assertEquals(true, newPointFrom.equals(new Point(5.0, 6.0)));
    }

    @Test
    public void equalsTest_equals() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line1 = new Line(pointFrom, pointTo);
        Line line2 = new Line(pointFrom, pointTo);

        assertEquals(true, line1.equals(line2));
        assertEquals(true, line2.equals(line1));
        assertEquals(true, line1.equals(line1));
    }

    @Test
    public void equalsTest_notEquals() {
        Point pointTo1 = new Point(1.0, 2.0);
        Point pointFrom1 = new Point(2.0, 1.0);

        Point pointTo2 = new Point(2.0, 3.0);
        Point pointFrom2 = new Point(4.0, 5.0);

        Line line1 = new Line(pointFrom1, pointTo1);
        Line line2 = new Line(pointFrom2, pointTo2);

        assertEquals(false, line1.equals(null));
        assertEquals(false, line1.equals(pointTo1));
        assertEquals(false, line1.equals(line2));
    }

    @Test
    public void toStringTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        assertEquals("Line center: (x = 1.5, y = 1.5) from: Point: x = 2.0, y = 1.0; to Point: x = 1.0, y = 2.0", line.toString());
    }
    
    @Test
    public void cloneTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        Line cloned = null;
        try {
            cloned = line.clone();
        } catch (CloneNotSupportedException ex) {
            ;
        }
        assertEquals(true, line.equals(cloned));
        
        line.moveBy(1, 2);
        assertEquals(false, line.equals(cloned));
    }
}