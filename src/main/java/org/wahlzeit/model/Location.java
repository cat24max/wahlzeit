package org.wahlzeit.model;

import java.util.*;

import org.wahlzeit.utils.*;

/**
 * A location represents a location (duh).
 */
public class Location {

    public Coordinate coordinate;

    /**
     *
     * @methodtype constructor
     */
    public Location(double x, double y, double z) {
        this.coordinate = CartesianCoordinate.getCartesianCoordinateObject(x, y, z);
    }

    /**
	 * 
	 * @methodtype get
	 */
    public Coordinate getCoordinate() {
        return coordinate;
    }




}