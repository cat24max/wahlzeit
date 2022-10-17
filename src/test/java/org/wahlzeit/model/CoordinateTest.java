package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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





}
