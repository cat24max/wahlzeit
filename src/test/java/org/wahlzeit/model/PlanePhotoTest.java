package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Test cases for the PlanePhotoTest class.
 */
public class PlanePhotoTest {

    @Mock
    private ResultSet mockedRset;
    private ResultSet emptyMockedRset;

    /**
     *
     */
    @Before
    public void createMockedRset() throws SQLException {
        mockedRset = mock(ResultSet.class);
        emptyMockedRset = mock(ResultSet.class);
        // These 2 columns are required, because they are required arguments
        when(mockedRset.getString("owner_email_address")).thenReturn("test@example.com");
        when(mockedRset.getString("owner_home_page")).thenReturn("http://example.com");

        when(mockedRset.getString("plane_type")).thenReturn("A359");
        when(mockedRset.getString("plane_airport_location")).thenReturn("NUE");
    }

    /**
     *
     */
    @Test
    public void testReadFrom() throws SQLException {
        PlanePhoto photo = new PlanePhoto(mockedRset);

        assertEquals("A359", photo.getAircraft().getAircraftType().getTypestring());
        assertEquals("NUE", photo.getAirportLocation());
    }

    /**
     *
     */
    @Test
    public void testWriteOn() throws SQLException {
        PlanePhoto photo = new PlanePhoto(mockedRset);
        photo.writeOn(emptyMockedRset);

        verify(emptyMockedRset, times(1)).updateString(eq("plane_type"), eq("A359"));
        verify(emptyMockedRset, times(1)).updateString(eq("plane_airport_location"), eq("NUE"));
    }

}
