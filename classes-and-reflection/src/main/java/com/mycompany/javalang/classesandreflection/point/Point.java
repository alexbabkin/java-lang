package com.mycompany.javalang.classesandreflection.point;

import java.lang.Cloneable;
import java.util.Objects;
import java.lang.CloneNotSupportedException;

public class Point implements Cloneable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void moveBy(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override 
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (getClass() != other.getClass()) return false;
        Point otherPoint = (Point) other;
        return (x == otherPoint.x && y == otherPoint.y);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": x = " + x + ", y = " + y;
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    }
}