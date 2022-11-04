package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    
    @Override
    public boolean isEqual(Coordinate other) {
        if(this == other) return true;
        if(other == null) return false;
        return this.asCartesianCoordinate().isEqual(other.asCartesianCoordinate());
    }

    protected boolean isDoubleEqual(double one, double two) {
        double epsilon = 0.001;
        double diff = 0;
        if(one >= two) {
            diff = one - two;
        } else {
            diff = two - one;
        }
        return diff < epsilon;
    }

    /**
	 * 
	 */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Coordinate)) return false;
        return this.isEqual((Coordinate) other);
    }

    @Override
    public double getCartesianDistance(Coordinate other) {
        return this.asCartesianCoordinate().getCartesianDistance(other);
    }

    @Override
    public double getCentralAngle(Coordinate otherCoordinate) {
        return this.asSphericCoordinate().getCentralAngle(otherCoordinate);
    }

}
