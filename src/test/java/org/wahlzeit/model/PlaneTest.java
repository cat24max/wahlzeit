package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testPlaneTypeSubtype() {
        PlaneType sevenFourSeven = new PlaneType("B740");
        Plane a = new Plane("B744");  // Boeing 747-400
        Plane b = new Plane("B748");  // Boeing 747-8
        assertTrue("747-400 should be a 747", a.getAircraftType().isSubtype(sevenFourSeven));
        assertTrue("747-8 should be a 747", b.getAircraftType().isSubtype(sevenFourSeven));
    }

}
