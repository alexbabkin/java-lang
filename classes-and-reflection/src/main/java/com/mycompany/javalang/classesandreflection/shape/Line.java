package com.mycompany.javalang.classesandreflection.shape;

import com.mycompany.javalang.classesandreflection.point.Point;
import java.util.Objects;

public class Line extends Shape implements Cloneable {
    private Point from;
    private Point to;

    private static Point calcCenter(Point from, Point to) throws IllegalArgumentException {
        if (from == null || to == null) {
            throw new IllegalArgumentException("from and to must not be null");
        }
        return new Point((from.getX() + to.getX()) / 2, (from.getY() + to.getY()) / 2);
    }

    public Line(Point from, Point to) {
        super(calcCenter(from, to));
        this.from = from;
        this.to = to;
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    @Override
    protected void moveElementsBy(double dx, double dy) {
        from.moveBy(dx, dy);
        to.moveBy(dx, dy);
    }

    @Override
    public int hashCode() {
        // we do not take center into account, since it is uniquely determined by from and to
        return Objects.hash(from, to);
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        Line otherLine = (Line) other;
        return Objects.equals(from, otherLine.from) && Objects.equals(to, otherLine.to);
    }

    @Override
    public String toString() {
        return super.toString() + " from: " + from.toString() + "; to " + to.toString();
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line cloned = (Line) super.clone();
        cloned.from = from.clone();
        cloned.to = to.clone();
        return cloned;
    }
}
