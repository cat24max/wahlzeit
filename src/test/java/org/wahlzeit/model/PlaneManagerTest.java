package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Test cases for the Gender class.
 */
public class PlaneManagerTest {

    @Test
    public void testPlaneManagerValueObject() {
        PlaneManager manager = PlaneManager.getInstance();
        Plane a = manager.createPlane("A388");
        Plane b = manager.createPlane("A388");
        Plane c = manager.createPlane("A359");
        assertEquals("Planes with same type should be equal", a, b);
        assertNotEquals("Planes with different type should not be equal", a, c);
    }

}
