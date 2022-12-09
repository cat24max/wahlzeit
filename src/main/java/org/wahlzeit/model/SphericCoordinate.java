package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public class SphericCoordinate extends AbstractCoordinate{
    
    private double phi, theta, radius;

    private static Map<Integer, SphericCoordinate> cache = new HashMap<>();

    /**
     *
     * @methodtype constructor
     */
    private SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
        assertClassInvariants();
    }

    public static SphericCoordinate getSphericCoordinateObject(double phi, double theta, double radius) {
        int hash = SphericCoordinate.calculateHash(phi, theta, radius);
        if(cache.containsKey(hash)) {
            return cache.get(hash);
        }
        SphericCoordinate newObject = new SphericCoordinate(phi, theta, radius);
        cache.put(hash, newObject);
        return newObject;
    }

    private static int calculateHash(double phi, double theta, double radius) {
        int hashX = Double.hashCode(phi);
        int hashY = Double.hashCode(theta);
        int hashZ = Double.hashCode(radius);
        return hashX + hashY + hashZ;
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

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        CartesianCoordinate result = CartesianCoordinate.getCartesianCoordinateObject(x, y, z);
        assertNotNull(result);
        return result;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }
    
    /**
	 * https://wikimedia.org/api/rest_v1/media/math/render/svg/87cea288a5b6e80757bc81375c3b6a38a30a5184
	 */
    @Override
    public double getCentralAngle(Coordinate other) {
        assertClassInvariants();
        assertNotNull(other);
        SphericCoordinate sph = other.asSphericCoordinate();
        assertNotNull(sph);

        double bigPhiThis = Math.toRadians(90) - this.getTheta();
        double bigPhiOther = Math.toRadians(90) - sph.getTheta();
        double delta = Math.abs(this.getPhi() - sph.getPhi());

        double num = Math.sqrt(
                Math.pow(Math.cos(bigPhiOther) * Math.sin(delta), 2) +
                Math.pow((Math.cos(bigPhiThis) * Math.sin(bigPhiOther) -
                Math.sin(bigPhiThis) * Math.cos(bigPhiOther) * Math.cos(delta)), 2)
        );

        double denom = Math.sin(bigPhiThis) * Math.sin(bigPhiOther) + Math.cos(bigPhiThis) * Math.cos(bigPhiOther) * Math.cos(delta);
        assertClassInvariants();
        double result = Math.atan(num / denom);
        assertValidCenterAngle(result);
        return result;
    }

    @Override
    void assertClassInvariants() {
        // TODO Auto-generated method stub
        assertDoubleIsValid(radius);
        assertDoubleIsValid(phi);
        assertDoubleIsValid(theta);
        assertPositive(radius);
    }

}
