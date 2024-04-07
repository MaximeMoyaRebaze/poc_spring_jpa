package com.maxime.corePackage.domains.visitorExample.visitor;

import com.maxime.corePackage.domains.visitorExample.entities.Circle;
import com.maxime.corePackage.domains.visitorExample.entities.Dot;

public class VisitorShapeImplementation implements  VisitorShape {
    @Override
    public void visitDot(Dot dot) {
        System.out.println("start -visitDot-");
        dot.setCoordinates(11,22);
    }

    @Override
    public void visitCircle(Circle circle) {
        System.out.println("start -visitCircle-");
        circle.setCenter();
        circle.setDiameter(42);
    }
}
