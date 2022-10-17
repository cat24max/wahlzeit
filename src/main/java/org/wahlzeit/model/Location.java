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
        this.coordinate = new Coordinate(x, y, z);
    }




}