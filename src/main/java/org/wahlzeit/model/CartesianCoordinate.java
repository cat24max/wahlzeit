package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        patternName = "ValueObject",
        participants = {}
)
public class CartesianCoordinate extends AbstractCoordinate {
    
    private double x, y, z;

    private static Map<Integer, CartesianCoordinate> cache = new HashMap<>();

    /**
     *
     * @methodtype constructor
     */
    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        assertClassInvariants();
    }

    public static CartesianCoordinate getCartesianCoordinateObject(double x, double y, double z) {
        int hash = CartesianCoordinate.calculateHash(x, y, z);
        if(cache.containsKey(hash)) {
            return cache.get(hash);
        }
        CartesianCoordinate newObject = new CartesianCoordinate(x, y, z);
        cache.put(hash, newObject);
        return newObject;
    }

    private static int calculateHash(double x, double y, double z) {
        int hashX = Double.hashCode(x);
        int hashY = Double.hashCode(y);
        int hashZ = Double.hashCode(z);
        return hashX + hashY + hashZ;
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
        assertNotNull(origin);
        double radius = this.getCartesianDistance(origin);
        assertDoubleIsValid(radius);
        assertPositive(radius);
        if(((Double) radius).equals(0.0)) return SphericCoordinate.getSphericCoordinateObject(0, 0, 0);

        final double theta = Math.acos(z / radius);
        final double phi = Math.atan2(y, x);
        SphericCoordinate result = SphericCoordinate.getSphericCoordinateObject(phi, theta, radius);
        assertNotNull(result);
        return result;
    }

    @Override
    public double getCartesianDistance(Coordinate other) {
        assertNotNull(other);
        return this.getDistance(other.asCartesianCoordinate());
    }

    @Override
    void assertClassInvariants() {
        // TODO Auto-generated method stub
        assertDoubleIsValid(x);
        assertDoubleIsValid(y);
        assertDoubleIsValid(z);
    }

}
