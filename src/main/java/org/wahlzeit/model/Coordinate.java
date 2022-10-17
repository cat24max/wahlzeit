package org.wahlzeit.model;

import java.util.*;

import org.wahlzeit.utils.*;

/**
 * A location represents a location (duh).
 */
public class Coordinate {

    private double x, y, z;

    /**
     *
     * @methodtype constructor
     */
    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getX() {
        return x;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getY() {
        return y;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getZ() {
        return z;
    }

    /**
	 * 
	 * @methodtype get
	 */
    protected double getDistance(Coordinate other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2) + Math.pow(other.z - this.z, 2));
    }

    /**
	 * 
	 * @methodtype boolean-query
	 */
    protected boolean isEqual(Coordinate other) {
        if(this == other) return true;
        if(other == null) return false;
        return ((Double) this.x).equals(other.x) && ((Double) this.y).equals(other.y) && ((Double) this.z).equals(other.z);
    }

    /**
	 * 
	 */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Coordinate)) return false;
        return this.isEqual((Coordinate) other);
    }

}