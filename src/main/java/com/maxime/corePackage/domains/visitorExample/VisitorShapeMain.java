package com.maxime.corePackage.domains.visitorExample;

import com.maxime.corePackage.domains.visitorExample.entities.Circle;
import com.maxime.corePackage.domains.visitorExample.entities.Dot;
import com.maxime.corePackage.domains.visitorExample.visitor.VisitorShape;
import com.maxime.corePackage.domains.visitorExample.visitor.VisitorShapeImplementation;

public class VisitorShapeMain {
    public static void main(String[] args) {

        // INSTANCE VISITOR :
        System.out.println();
        VisitorShape visitorShape = new VisitorShapeImplementation();
        Dot dot = new Dot();
        dot.setCoordinates(0,0);
        Circle circle = new Circle(dot);

        // ACCEPT VISITOR :
        System.out.println();
        circle.accept(visitorShape);
        dot.accept(visitorShape);
        circle.accept(visitorShape);

    }

}
