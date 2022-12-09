package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the Gender class.
 */
public class CoordinateTest {

    /**
	 *
	 */
	public void assertCartesianDistance(CartesianCoordinate coord1, CartesianCoordinate coord2, double distance) {
        assertEquals(distance, coord1.getDistance(coord2), 0.1);
	}

    /**
	 *
	 */
	@Test
	public void testCartesianDistanceCalculations() {
        assertCartesianDistance(CartesianCoordinate.getCartesianCoordinateObject(2, 1, 0), CartesianCoordinate.getCartesianCoordinateObject(2, 1, 2), 2.0);
        assertCartesianDistance(CartesianCoordinate.getCartesianCoordinateObject(2, 13, -15), CartesianCoordinate.getCartesianCoordinateObject(-9, 8, 2), 20.9);
	}

    /**
	 *
	 */
	@Test
	public void testEqualsWrongValues() {
        assertFalse(CartesianCoordinate.getCartesianCoordinateObject(2, 1, 3).equals(new Object()));
        assertFalse(new Object().equals(CartesianCoordinate.getCartesianCoordinateObject(2, 1, 3)));
	}

    /**
	 *
	 */
	@Test
	public void testEqualsSameNotSame() {
        CartesianCoordinate coord = CartesianCoordinate.getCartesianCoordinateObject(2, 1, 0);
        assertTrue(CartesianCoordinate.getCartesianCoordinateObject(2, 1, 0).equals(coord));
        assertTrue(CartesianCoordinate.getCartesianCoordinateObject(2, 1, 0).equals(CartesianCoordinate.getCartesianCoordinateObject(2, 1, 0)));
        assertFalse(CartesianCoordinate.getCartesianCoordinateObject(2, 1, 3).equals(coord));

		SphericCoordinate coord2 = SphericCoordinate.getSphericCoordinateObject(23.64723, 9.7632, 120);
		assertTrue(SphericCoordinate.getSphericCoordinateObject(23.64723, 9.7632, 120).equals(coord2));
        assertTrue(SphericCoordinate.getSphericCoordinateObject(23.64723, 9.7632, 120).equals(SphericCoordinate.getSphericCoordinateObject(23.64723, 9.7632, 120)));
        assertFalse(SphericCoordinate.getSphericCoordinateObject(23.64723, 9.7632, 120.252).equals(coord2));
	}

	/**
	 *
	 */
	@Test
	public void testCartesianToSphericConversion() {
        CartesianCoordinate coord = CartesianCoordinate.getCartesianCoordinateObject(2, 1, 0);
		SphericCoordinate sph = coord.asSphericCoordinate();

		assertEquals((Double) sph.getPhi(), (Double) 0.4636476, 0.01);
		assertEquals((Double) sph.getTheta(), (Double) 1.5707963, 0.01);
		assertEquals((Double) sph.getRadius(), (Double) 2.23606, 0.01);
	}

	/**
	 *
	 */
	@Test
	public void testCentralAngle() {
		// Using a cartesian coord here on purpose
		CartesianCoordinate coord1 = CartesianCoordinate.getCartesianCoordinateObject(2, 1, 0);
        CartesianCoordinate coord2 = CartesianCoordinate.getCartesianCoordinateObject(5, 13.5, 420.42);
		
		double angleSame1 = coord1.getCentralAngle(coord1);
		double angleSame2 = coord2.getCentralAngle(coord2);

		double angle = coord1.getCentralAngle(coord2);
		double angleFlipped = coord1.getCentralAngle(coord2);

		assertEquals((Double) 0.0, (Double) angleSame1);
		assertEquals((Double) 0.0, (Double) angleSame2);
		assertEquals((Double) 1.54582, (Double) angle, 0.001);
		assertEquals((Double) 1.54582, (Double) angleFlipped, 0.001);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCreateCartesianCoordinateWithInvalidDouble() {
		CartesianCoordinate.getCartesianCoordinateObject(Double.NaN, 1, 0);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCreateSphericCoordinateWithInvalidDouble() {
		SphericCoordinate.getSphericCoordinateObject(Double.NaN, 1, 0);
	}

	/**
	 *
	 */
	@Test
	public void testCartesianCoordinateValueObjectDeduplication() {
		CartesianCoordinate a1 = CartesianCoordinate.getCartesianCoordinateObject(1, 2, 3.53);
		CartesianCoordinate b1 = CartesianCoordinate.getCartesianCoordinateObject(1, 2, 3.53);
		assertEquals("Two coordiantes with same values should be equal (ValueObjects 1)", a1, b1);

		SphericCoordinate a2 = SphericCoordinate.getSphericCoordinateObject(1, 2, 3.53);
		SphericCoordinate b2 = SphericCoordinate.getSphericCoordinateObject(1, 2, 3.53);
		assertEquals("Two coordiantes with same values should be equal (ValueObjects 2)", a2, b2);

		SphericCoordinate a3 = CartesianCoordinate.getCartesianCoordinateObject(1, 2, 3.53).asSphericCoordinate();
		SphericCoordinate b3 = CartesianCoordinate.getCartesianCoordinateObject(1, 2, 3.53).asSphericCoordinate();
		assertEquals("Two coordiantes with same values should be equal (ValueObjects 3)", a3, b3);
	}


}
