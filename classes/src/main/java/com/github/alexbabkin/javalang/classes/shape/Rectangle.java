package com.github.alexbabkin.javalang.classes.shape;

import com.github.alexbabkin.javalang.classes.point.Point;
import java.util.Objects;

public class Rectangle extends Shape {
    private Point topLeft;
    private double height;
    private double width;

    private static Point calcCenter(Point topLeft, double height, double width)
            throws IllegalArgumentException {
        if (topLeft == null) {
            throw new IllegalArgumentException("topLeft must not be null");
        }
        // top left corner is (0, 0)
        return new Point((topLeft.getX() + width / 2), (topLeft.getY() + height / 2));
    }

    public Rectangle(Point topLeft, double height, double width) {
        super(calcCenter(topLeft, height, width));
        this.topLeft = topLeft;
        this.height = height;
        this.width = width;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    protected void moveElementsBy(double dx, double dy) {
        topLeft.moveBy(dx, dy);
    }

    @Override
    public int hashCode() {
        // we do not take center into account, since it is uniquely determined by from and to
        return Objects.hash(topLeft, height, width);
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        Rectangle otherRectangle = (Rectangle) other;
        return Objects.equals(topLeft, otherRectangle.topLeft)
                && (width == otherRectangle.width)
                && (height == otherRectangle.height);
    }

    @Override
    public String toString() {
        return super.toString()
                + "; top left: "
                + topLeft.toString()
                + "; width "
                + width
                + "; height = "
                + height;
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        Rectangle cloned = (Rectangle) super.clone();
        cloned.topLeft = topLeft.clone();
        return cloned;
    }
}
