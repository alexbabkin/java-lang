package com.mycompany.javalang.classesandreflection.point;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LabeledPointTest {
    @Test
    public void getXTest() {
        LabeledPoint labeledPoint = new LabeledPoint("label", 1.0, 2.0);

        assertEquals(1.0, labeledPoint.getX(), 0.0);
    }

    @Test
    public void getYTest() {
        LabeledPoint labeledPoint = new LabeledPoint("label", 1.0, 2.0);

        assertEquals(2.0, labeledPoint.getY(), 0.0);
    }

    @Test
    public void getLabelTest() {
        LabeledPoint labeledPoint = new LabeledPoint("label", 1.0, 2.0);

        assertEquals("label", labeledPoint.getLabel());
    }

    @Test
    public void equalsTest_equals() {
        LabeledPoint labeledPoint1 = new LabeledPoint("label", 1.0, 2.0);
        LabeledPoint labeledPoint2 = new LabeledPoint("label", 1.0, 2.0);
        LabeledPoint labeledPoint3 = new LabeledPoint(null, 1.0, 2.0);
        LabeledPoint labeledPoint4 = new LabeledPoint(null, 1.0, 2.0);

        assertEquals(true, labeledPoint1.equals(labeledPoint1));
        assertEquals(true, labeledPoint1.equals(labeledPoint2));
        assertEquals(true, labeledPoint3.equals(labeledPoint4));
    }

    @Test
    public void equalsTest_notEquals() {
        LabeledPoint labeledPoint1 = new LabeledPoint("label", 1.0, 2.0);

        assertEquals(false, labeledPoint1.equals(null));
        assertEquals(false, labeledPoint1.equals(new Point(1.0, 1.0)));
        assertEquals(false, labeledPoint1.equals(new LabeledPoint("label1", 1.0, 2.0)));
        assertEquals(false, labeledPoint1.equals(new LabeledPoint("label", 2.0, 2.0)));
        assertEquals(false, labeledPoint1.equals(new LabeledPoint("label", 1.0, 3.0)));
        assertEquals(false, labeledPoint1.equals(new LabeledPoint(null, 1.0, 2.0)));
    }

    @Test
    public void toStringTest() {
        assertEquals("LabeledPoint: x = 1.1, y = 2.2, label = label", (new LabeledPoint("label", 1.1, 2.2)).toString());
        assertEquals("LabeledPoint: x = 1.1, y = 2.2, label = null", (new LabeledPoint(null, 1.1, 2.2)).toString());
    }
}