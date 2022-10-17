package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test cases for the Gender class.
 */
public class PhotoTest {

	/**
	 *
	 */
	@Test
	public void testCreatePhotoWithNoLocation() {
        Photo photo = new Photo();
        assertNull(photo.getLocation());
	}

    /**
	 *
	 */
	@Test
	public void testCreatePhotoWithLocation() {
        Photo photo = new Photo();
        Coordinate coord = new Coordinate(1, 2, 3);

        photo.setLocation(new Location(1, 2, 3));
        assertEquals(1.0, photo.getLocation().getCoordinate().getX(), 0);
        assertEquals(2.0, photo.getLocation().getCoordinate().getY(), 0);
        assertEquals(3.0, photo.getLocation().getCoordinate().getZ(), 0);

        photo.setLocation(1, 2, 3);
        assertEquals(1.0, photo.getLocation().getCoordinate().getX(), 0);
        assertEquals(2.0, photo.getLocation().getCoordinate().getY(), 0);
        assertEquals(3.0, photo.getLocation().getCoordinate().getZ(), 0);
	}


}
