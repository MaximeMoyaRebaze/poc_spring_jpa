package com.maxime.corePackage.domains.visitorExample.visitor;

import com.maxime.corePackage.domains.visitorExample.entities.Circle;
import com.maxime.corePackage.domains.visitorExample.entities.Dot;

public interface VisitorShape {
    void visitDot(Dot dot);
    void visitCircle(Circle circle);
}
