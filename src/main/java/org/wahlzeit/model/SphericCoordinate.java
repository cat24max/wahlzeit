package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {
    
    private double phi, theta, radius;

    /**
     *
     * @methodtype constructor
     */
    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getPhi() {
        return phi;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getTheta() {
        return theta;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getRadius() {
        return radius;
    }

    /**
	 * 
	 * @methodtype boolean-query
	 */
    protected boolean isEqual(SphericCoordinate other) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
	 * 
	 */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof SphericCoordinate)) return false;
        return this.isEqual((SphericCoordinate) other);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getCartesianDistance(Coordinate other) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate other) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEqual(Coordinate other) {
        // TODO Auto-generated method stub
        return false;
    }

}
