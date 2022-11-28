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
	@Test
	public void testCreateCartesianCoordinate() {
        CartesianCoordinate coord = new CartesianCoordinate(1, 2, 3);
        assertEquals(1.0, coord.getX(), 0);
        assertEquals(2.0, coord.getY(), 0);
        assertEquals(3.0, coord.getZ(), 0);
	}

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
        assertCartesianDistance(new CartesianCoordinate(2, 1, 0), new CartesianCoordinate(2, 1, 2), 2.0);
        assertCartesianDistance(new CartesianCoordinate(2, 13, -15), new CartesianCoordinate(-9, 8, 2), 20.9);
	}

    /**
	 *
	 */
	@Test
	public void testEqualsWrongValues() {
        assertFalse(new CartesianCoordinate(2, 1, 0).equals(null));
        assertFalse(new CartesianCoordinate(2, 1, 3).equals(new Object()));
        assertFalse(new Object().equals(new CartesianCoordinate(2, 1, 3)));
        assertFalse(new CartesianCoordinate(2, 1, 3).isEqual(null));
	}

    /**
	 *
	 */
	@Test
	public void testEqualsSameNotSame() {
        CartesianCoordinate coord = new CartesianCoordinate(2, 1, 0);
        assertTrue(new CartesianCoordinate(2, 1, 0).equals(coord));
        assertTrue(new CartesianCoordinate(2, 1, 0).equals(new CartesianCoordinate(2, 1, 0)));
        assertFalse(new CartesianCoordinate(2, 1, 3).equals(coord));

		SphericCoordinate coord2 = new SphericCoordinate(23.64723, 9.7632, 120);
		assertTrue(new SphericCoordinate(23.64723, 9.7632, 120).equals(coord2));
        assertTrue(new SphericCoordinate(23.64723, 9.7632, 120).equals(new SphericCoordinate(23.64723, 9.7632, 120)));
        assertFalse(new SphericCoordinate(23.64723, 9.7632, 120.252).equals(coord2));
	}

	/**
	 *
	 */
	@Test
	public void testCartesianToSphericConversion() {
        CartesianCoordinate coord = new CartesianCoordinate(2, 1, 0);
		SphericCoordinate sph = coord.asSphericCoordinate();

		assertEquals((Double) sph.getPhi(), (Double) 0.4636476, 0.01);
		assertEquals((Double) sph.getTheta(), (Double) 1.5707963, 0.01);
		assertEquals((Double) sph.getRadius(), (Double) 2.23606, 0.01);
	}

	/**
	 *
	 */
	@Test
	public void testCartesianToSphericToCartesianConversion() {
        CartesianCoordinate coord = new CartesianCoordinate(5, 13.5, 420.69);
		SphericCoordinate sph = coord.asSphericCoordinate();
		CartesianCoordinate backConverted = sph.asCartesianCoordinate();

		assertEquals((Double) coord.getX(), (Double) backConverted.getX(), 0.01);
		assertEquals((Double) coord.getY(), (Double) backConverted.getY(), 0.01);
		assertEquals((Double) coord.getZ(), (Double) backConverted.getZ(), 0.01);
		assertEquals(coord, backConverted);
	}

	/**
	 *
	 */
	@Test
	public void testCentralAngle() {
		// Using a cartesian coord here on purpose
		CartesianCoordinate coord1 = new CartesianCoordinate(2, 1, 0);
        CartesianCoordinate coord2 = new CartesianCoordinate(5, 13.5, 420.42);
		
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
		new CartesianCoordinate(Double.NaN, 1, 0);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCreateSphericCoordinateWithInvalidDouble() {
		new SphericCoordinate(Double.NaN, 1, 0);
	}


}
