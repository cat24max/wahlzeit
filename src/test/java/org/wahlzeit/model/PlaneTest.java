package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test cases for the Gender class.
 */
public class PlaneTest {

    @Test
    public void testEquals() {
        PlaneType type = PlaneManager.getInstance().createPlane("A359").getAircraftType();
        Plane a = new Plane(type);
        Plane b = new Plane("A359");
        assertEquals(a, b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectICAOCode() {
        new Plane("A359LOOOOOOOOOL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnsetPlaneType() {
        new Plane("A359").getAircraftType().setTypestring("");
    }

}
