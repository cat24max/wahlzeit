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
	}





}
