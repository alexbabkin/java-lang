package com.mycompany.javalang.classesandreflection.shape;

import com.mycompany.javalang.classesandreflection.point.Point;
import java.util.Objects;

public class Circle extends Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    // getCeter already defined in Shape

    public double getRadius() {
        return radius;
    }

    @Override
    protected void moveElementsBy(double dx, double dy) {
        // do nothing
    }

    @Override
    public int hashCode() {
        // we do not take center into account, since it is uniquely determined by from and to
        return Objects.hash(center, radius);
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        Circle otherCircle = (Circle) other;
        return (radius == otherCircle.radius);
    }

    @Override
    public String toString() {
        return super.toString() + "; radius = " + radius;
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }
}
