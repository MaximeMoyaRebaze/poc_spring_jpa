package com.maxime.corePackage.domains.visitorExample.entities;

import com.maxime.corePackage.domains.visitorExample.visitor.VisitorShape;

public class Circle implements Shape {

    public Dot dot;

    public Circle(Dot dot) {
        this.dot = dot;
    }

    public void setCenter() {
        System.out.println("set center of the circle according to the dot {x=" + this.dot.getX() + ", y=" + this.dot.getY() + "}");
    }

    public void setDiameter(int diameter) {
        System.out.println("set diameter of the circle to {diameter= " + diameter + "}");
    }

    @Override
    public void accept(VisitorShape visitorShape) {
        visitorShape.visitCircle(this);
    }

}
