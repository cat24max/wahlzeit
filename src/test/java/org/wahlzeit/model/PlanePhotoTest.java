package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Test cases for the PlanePhotoTest class.
 */
public class PlanePhotoTest {

    /**
     *
     */
    @Test
    public void testCreate() throws SQLException {
        ResultSet rset = mock(ResultSet.class);
        
        // These 2 columns are required, because they are required arguments
        when(rset.getString("owner_email_address")).thenReturn("test@example.com");
        when(rset.getString("owner_home_page")).thenReturn("http://example.com");
        
        when(rset.getString("plane_type")).thenReturn("A359");
        when(rset.getString("plane_airport_location")).thenReturn("NUE");

        PlanePhoto photo = new PlanePhoto(rset);

        assertEquals("A359", photo.getAircraftType());
        assertEquals("NUE", photo.getAirportLocation());
    }

}
