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
        CartesianCoordinate origin = new CartesianCoordinate(0, 0, 0);
        double radius = this.getCartesianDistance(origin);
        if(((Double) radius).equals(0.0)) return new SphericCoordinate(0, 0, 0);

        double theta = Math.atan(y / x);
        double phi = Math.atan(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) / z);
        return new SphericCoordinate(phi, theta, radius);
    }

    @Override
    public double getCentralAngle(Coordinate other) {
        return this.asSphericCoordinate().getCentralAngle(other);
    }

    @Override
    public boolean isEqual(Coordinate other) {
        return this.isEqual(other.asCartesianCoordinate());
    }

}
