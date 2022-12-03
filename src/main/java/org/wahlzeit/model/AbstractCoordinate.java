package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    
    @Override
    public boolean isEqual(Coordinate other) {
        assertClassInvariants();
        assertNotNull(other);
        if(this == other) return true;
        if(other == null) return false;
        boolean result = this.asCartesianCoordinate().isEqual(other.asCartesianCoordinate());
        assertClassInvariants();
        return result;
    }

    protected boolean isDoubleEqual(double one, double two) {
        assertClassInvariants();
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
        assertClassInvariants();
        assertNotNull(other);
        if(!(other instanceof Coordinate)) return false;
        boolean result = this.isEqual((Coordinate) other);
        assertClassInvariants();
        return result;
    }

    @Override
    public double getCartesianDistance(Coordinate other) {
        assertClassInvariants();
        assertNotNull(other);
        double result = this.asCartesianCoordinate().getCartesianDistance(other);
        assertPositive(result);
        assertClassInvariants();
        return result;
    }

    @Override
    public double getCentralAngle(Coordinate otherCoordinate) {
        assertClassInvariants();
        assertNotNull(otherCoordinate);
        double result = this.asSphericCoordinate().getCentralAngle(otherCoordinate);
        assertValidCenterAngle(result);
        assertClassInvariants();
        return result;
    }

    abstract void assertClassInvariants();

    void assertNotNull(Object obj) {
        if(obj == null) throw new NullPointerException("object should not be null");
    }

    void assertDoubleIsValid(double d) {
        Double check = (Double) d;
        if(check.isNaN()) throw new IllegalArgumentException("double should be a number");
        if(check.isInfinite()) throw new IllegalArgumentException("double should not be infinite");
    }

    void assertPositive(double d){
        if (d < 0) throw new IllegalArgumentException("double should be positive");
    }

    // assertPositive and assertNotNegative was a nice braindead moment :D

    void assertValidCenterAngle(double ang){
        if(ang < Math.toRadians(0) || ang > Math.toRadians(180)) throw new RuntimeException("center angle double should be between 0 and 180 deg");
    }
    
}
