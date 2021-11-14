package com.github.alexbabkin.javalang.classes.shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.alexbabkin.javalang.classes.point.Point;
import org.junit.Test;

public class RectangleTest {
    @Test
    public void createRectangle_NullParametersException() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> new Rectangle(null, 10.0, 9.0));
        assertEquals("topLeft must not be null", exception.getMessage());
    }

    @Test
    public void getTopLeftTest() {
        Point pointTopLeft = new Point(1.0, 2.0);

        Rectangle rectangle = new Rectangle(pointTopLeft, 10.0, 9.0);

        assertEquals(pointTopLeft, rectangle.getTopLeft());
    }

    @Test
    public void getHeightTest() {
        Point pointTopLeft = new Point(1.0, 2.0);

        Rectangle rectangle = new Rectangle(pointTopLeft, 10.0, 9.0);

        assertEquals(10.0, rectangle.getHeight(), 0.0);
    }

    @Test
    public void getWidthTest() {
        Point pointTopLeft = new Point(1.0, 2.0);

        Rectangle rectangle = new Rectangle(pointTopLeft, 10.0, 9.0);

        assertEquals(9.0, rectangle.getWidth(), 0.0);
    }

    @Test
    public void moveElementsByTest() {
        Point pointTopLeft = new Point(1.0, 2.0);
        Rectangle rectangle = new Rectangle(pointTopLeft, 10.0, 9.0);

        rectangle.moveElementsBy(3.0, 5.0);

        Point newPointTopLeft = rectangle.getTopLeft();

        assertEquals(new Point(4.0, 7.0), newPointTopLeft);
    }

    @Test
    public void equalsTest_equals() {
        Point pointTopLeft = new Point(1.0, 2.0);

        Rectangle rectangle1 = new Rectangle(pointTopLeft, 10.0, 9.0);
        Rectangle rectangle2 = new Rectangle(pointTopLeft, 10.0, 9.0);

        assertEquals(rectangle1, rectangle2);
        assertEquals(rectangle2, rectangle1);
        assertEquals(rectangle1, rectangle1);
    }

    @Test
    public void equalsTest_notEquals() {
        Point pointTopLeft1 = new Point(1.0, 2.0);
        Point pointTopLeft2 = new Point(3.0, 4.0);

        Rectangle rectangle1 = new Rectangle(pointTopLeft1, 10.0, 9.0);
        Rectangle rectangle2 = new Rectangle(pointTopLeft2, 10.0, 9.0);
        Rectangle rectangle3 = new Rectangle(pointTopLeft1, 9.0, 9.0);
        Rectangle rectangle4 = new Rectangle(pointTopLeft1, 10.0, 10.0);

        assertNotEquals(null, rectangle1);
        assertNotEquals(rectangle1, pointTopLeft1);
        assertNotEquals(rectangle1, rectangle2);
        assertNotEquals(rectangle1, rectangle3);
        assertNotEquals(rectangle1, rectangle4);
    }

    @Test
    public void toStringTest() {
        Point pointTopLeft = new Point(1.0, 2.0);
        Rectangle rectangle = new Rectangle(pointTopLeft, 10.0, 9.0);

        assertEquals(
                "Rectangle center: (x = 5.5, y = 7.0); top left: Point: x = 1.0, y = 2.0; width 9.0; height = 10.0",
                rectangle.toString());
    }

    @Test
    public void cloneTest() {
        Point pointTopLeft = new Point(1.0, 2.0);
        Rectangle rectangle = new Rectangle(pointTopLeft, 10.0, 9.0);

        Rectangle cloned = null;
        try {
            cloned = rectangle.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        assertEquals(rectangle, cloned);

        rectangle.moveBy(1, 2);
        assertNotEquals(rectangle, cloned);
    }
}
