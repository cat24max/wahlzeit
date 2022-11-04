package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {
    
    private double x, y, z;

    /**
     *
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
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
    protected double getDistance(CartesianCoordinate other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2) + Math.pow(other.z - this.z, 2));
    }

    /**
	 * 
	 * @methodtype boolean-query
	 */
    protected boolean isEqual(CartesianCoordinate other) {
        if(this == other) return true;
        if(other == null) return false;
        return ((Double) this.x).equals(other.x) && ((Double) this.y).equals(other.y) && ((Double) this.z).equals(other.z);
    }

    /**
	 * 
	 */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof CartesianCoordinate)) return false;
        return this.isEqual((CartesianCoordinate) other);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate other) {
        return this.getDistance(other.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getCentralAngle(Coordinate other) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEqual(Coordinate other) {
        return this.isEqual(other.asCartesianCoordinate());
    }

}
