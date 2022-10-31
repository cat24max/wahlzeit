package org.wahlzeit.model;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class PlanePhotoManagerTest {
    
    /**
     *
     */
    @Test
    public void testReadOn() throws SQLException {
        ResultSet rset = mock(ResultSet.class);
        
        // These 2 columns are required, because they are required arguments
        when(rset.getString("owner_email_address")).thenReturn("test@example.com");
        when(rset.getString("owner_home_page")).thenReturn("http://example.com");
        
        when(rset.getString("plane_type")).thenReturn("A359");
        when(rset.getString("plane_airport_location")).thenReturn("NUE");

        PlanePhoto photo = PlanePhotoManager.getInstance().createObject(rset);

        assertEquals("A359", photo.getAircraftType());
        assertEquals("NUE", photo.getAirportLocation());
    }
    

}
