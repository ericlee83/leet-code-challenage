package com.pattern.creational.factory;

import com.pattern.creational.factory.polygons.Square;
import com.pattern.creational.factory.polygons.Triangle;


/*
 * When the implementation of an interface or an abstract class is expected to change frequently
 * When the current implementation cannot comfortably accommodate new change
 * When the initialization process is relatively simple, and the constructor only requires a handful of parameters
 */
public class PolygonFactory {
    public Polygon getPolygon(int numberOfSides) {
        if (numberOfSides == 3) {
            return new Triangle();
        }
        if (numberOfSides == 4) {
            return new Square();
        }
        return null;
    }
}
