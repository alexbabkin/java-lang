package com.mycompany.javalang.classesandreflection.point;

import java.util.Objects;

public class LabeledPoint extends Point {
    private String label;
    
    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, super.hashCode());
    }

    @Override 
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        LabeledPoint otherPoint = (LabeledPoint)other;
        return (label == otherPoint.label);
    }

    @Override
    public String toString() {
        return super.toString() + ", label = " + label;
    }
}