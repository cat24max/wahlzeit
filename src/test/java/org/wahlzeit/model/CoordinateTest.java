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


}
