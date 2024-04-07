package com.maxime.corePackage.domains.visitorExample.entities;


import com.maxime.corePackage.domains.visitorExample.visitor.VisitorShape;

public interface Shape {
    void accept(VisitorShape visitorShape);
}
