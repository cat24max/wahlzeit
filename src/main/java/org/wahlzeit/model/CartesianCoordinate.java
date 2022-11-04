package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
    
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
        return isDoubleEqual(this.x, other.x) && isDoubleEqual(this.y, other.y) && isDoubleEqual(this.z, other.z);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    /**
	 * Source: https://keisan.casio.com/exec/system/1359533867
	 */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        CartesianCoordinate origin = new CartesianCoordinate(0, 0, 0);
        double radius = this.getCartesianDistance(origin);
        if(((Double) radius).equals(0.0)) return new SphericCoordinate(0, 0, 0);

        final double theta = Math.acos(z / radius);
        final double phi = Math.atan2(y, x);
        return new SphericCoordinate(phi, theta, radius);
    }

    @Override
    public double getCartesianDistance(Coordinate other) {
        return this.getDistance(other.asCartesianCoordinate());
    }

}
