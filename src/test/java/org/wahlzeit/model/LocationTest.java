package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Gender class.
 */
public class LocationTest {

	/**
	 *
	 */
	@Test
	public void testCreateLocation() {
        Location location = new Location(1, 2, 3);
        assertEquals(1.0, location.getCoordinate().asCartesianCoordinate().getX(), 0);
        assertEquals(2.0, location.getCoordinate().asCartesianCoordinate().getY(), 0);
        assertEquals(3.0, location.getCoordinate().asCartesianCoordinate().getZ(), 0);
	}


}
