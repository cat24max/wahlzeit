package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Test cases for the Photo class.
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
        Coordinate coord = CartesianCoordinate.getCartesianCoordinateObject(1, 2, 3);

        photo.setLocation(new Location(1, 2, 3));
        assertEquals(1.0, photo.getLocation().getCoordinate().asCartesianCoordinate().getX(), 0);
        assertEquals(2.0, photo.getLocation().getCoordinate().asCartesianCoordinate().getY(), 0);
        assertEquals(3.0, photo.getLocation().getCoordinate().asCartesianCoordinate().getZ(), 0);

        photo.setLocation(1, 2, 3);
        assertEquals(1.0, photo.getLocation().getCoordinate().asCartesianCoordinate().getX(), 0);
        assertEquals(2.0, photo.getLocation().getCoordinate().asCartesianCoordinate().getY(), 0);
        assertEquals(3.0, photo.getLocation().getCoordinate().asCartesianCoordinate().getZ(), 0);
    }

    /**
     * @throws SQLException
     *
     */
    @Test
    public void testStore() throws SQLException {
        Photo photo = mock(Photo.class);
        Location coord = new Location(13, 2.3546465, 3);
        photo.setLocation(coord);
        photo.addToPraise(10);

        ResultSet rset = mock(ResultSet.class);
        photo.writeOn(rset);

        verify(photo, times(1)).writeOn(rset);
    }

    /**
     * @throws SQLException
     *
     */
    @Test
    public void testRead() throws SQLException {
        Photo photo = mock(Photo.class);
        ResultSet rset = mock(ResultSet.class);

        photo.readFrom(rset);
        verify(photo, times(1)).readFrom(rset);
    }

}
