package com.maxime.corePackage.domains.visitorExample.entities;

import com.maxime.corePackage.domains.visitorExample.visitor.VisitorShape;

public class Dot implements Shape {
    private int x, y;

    public void setCoordinates(int x, int y) {
        System.out.println("set coordinates of the dot to {x=" + x + ", y=" + y + "}");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void accept(VisitorShape visitorShape) {
        visitorShape.visitDot(this);
    }

}
