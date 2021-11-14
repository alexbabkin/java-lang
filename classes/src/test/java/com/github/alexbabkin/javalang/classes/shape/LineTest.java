package com.github.alexbabkin.javalang.classes.shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.alexbabkin.javalang.classes.point.Point;
import org.junit.Test;

public class LineTest {
    @Test
    public void createLine_NullParametersException() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> new Line(null, new Point(1, 2)));
        assertEquals("from and to must not be null", exception.getMessage());

        exception =
                assertThrows(IllegalArgumentException.class, () -> new Line(new Point(1, 2), null));
        assertEquals("from and to must not be null", exception.getMessage());
    }

    @Test
    public void getFromTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        assertEquals(pointFrom, line.getFrom());
    }

    @Test
    public void getToTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        assertEquals(pointTo, line.getTo());
    }

    @Test
    public void calcCenterTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 3.0);

        Line line = new Line(pointFrom, pointTo);

        assertEquals(new Point(1.5, 2.5), line.getCenter());
    }

    @Test
    public void moveElementsByTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        line.moveElementsBy(3.0, 5.0);

        Point newPointTo = line.getTo();
        Point newPointFrom = line.getFrom();

        assertEquals(newPointTo, new Point(4.0, 7.0));
        assertEquals(newPointFrom, new Point(5.0, 6.0));
    }

    @Test
    public void equalsTest_equals() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line1 = new Line(pointFrom, pointTo);
        Line line2 = new Line(pointFrom, pointTo);

        assertEquals(line1, line2);
        assertEquals(line2, line1);
        assertEquals(line1, line1);
    }

    @Test
    public void equalsTest_notEquals() {
        Point pointTo1 = new Point(1.0, 2.0);
        Point pointFrom1 = new Point(2.0, 1.0);

        Point pointTo2 = new Point(2.0, 3.0);
        Point pointFrom2 = new Point(4.0, 5.0);

        Line line1 = new Line(pointFrom1, pointTo1);
        Line line2 = new Line(pointFrom2, pointTo2);

        assertNotEquals(null, line1);
        assertNotEquals(line1, pointTo1);
        assertNotEquals(line1, line2);
    }

    @Test
    public void toStringTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        assertEquals(
                "Line center: (x = 1.5, y = 1.5); from: Point: x = 2.0, y = 1.0; to Point: x = 1.0, y = 2.0",
                line.toString());
    }

    @Test
    public void cloneTest() {
        Point pointTo = new Point(1.0, 2.0);
        Point pointFrom = new Point(2.0, 1.0);

        Line line = new Line(pointFrom, pointTo);

        Line cloned = null;
        try {
            cloned = line.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        assertEquals(line, cloned);

        line.moveBy(1, 2);
        assertNotEquals(line, cloned);
    }
}
