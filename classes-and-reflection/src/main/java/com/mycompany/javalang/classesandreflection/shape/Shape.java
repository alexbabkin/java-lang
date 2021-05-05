package com.mycompany.javalang.classesandreflection.shape;

import com.mycompany.javalang.classesandreflection.point.Point;
import java.util.Objects;

public abstract class Shape implements Cloneable {
    private Point center;

    protected abstract void moveElementsBy(double dx, double dy);

    public Shape(Point center) {
        if (center == null) {
            throw new IllegalArgumentException("Center must not be null");
        }
        this.center = center;
    }

    public void moveBy(double dx, double dy) {
        center.moveBy(dx, dy);
        moveElementsBy(dx, dy);
    }

    public Point getCenter() {
        return center;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (getClass() != other.getClass()) return false;
        Shape otherShape = (Shape) other;
        return Objects.equals(center, otherShape.center);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " center: (x = "
                + center.getX()
                + ", y = "
                + center.getY()
                + ")";
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape cloned = (Shape) super.clone();
        cloned.center = center.clone();
        return cloned;
    }
}
