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
	public void testCreateCoordinate() {
        Coordinate coord = new Coordinate(1, 2, 3);
        assertEquals(1.0, coord.getX(), 0);
        assertEquals(2.0, coord.getY(), 0);
        assertEquals(3.0, coord.getZ(), 0);
	}

    /**
	 *
	 */
	public void assertDistance(Coordinate coord1, Coordinate coord2, double distance) {
        assertEquals(distance, coord1.getDistance(coord2), 0.1);
	}

    /**
	 *
	 */
	@Test
	public void testDistanceCalculations() {
        assertDistance(new Coordinate(2, 1, 0), new Coordinate(2, 1, 2), 2.0);
        assertDistance(new Coordinate(2, 13, -15), new Coordinate(-9, 8, 2), 20.9);
	}

    /**
	 *
	 */
	@Test
	public void testEqualsWrongValues() {
        assertFalse(new Coordinate(2, 1, 0).equals(null));
        assertFalse(new Coordinate(2, 1, 3).equals(new Object()));
        assertFalse(new Object().equals(new Coordinate(2, 1, 3)));
        assertFalse(new Coordinate(2, 1, 3).isEqual(null));
	}

    /**
	 *
	 */
	@Test
	public void testEqualsSameNotSame() {
        Coordinate coord = new Coordinate(2, 1, 0);
        assertTrue(new Coordinate(2, 1, 0).equals(coord));
        assertTrue(new Coordinate(2, 1, 0).equals(new Coordinate(2, 1, 0)));
        assertFalse(new Coordinate(2, 1, 3).equals(coord));
	}





}
