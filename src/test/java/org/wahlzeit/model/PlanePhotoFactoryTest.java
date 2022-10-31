package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlanePhotoFactoryTest {

    /**
     *
     */
    @Test
    public void testGetInstance() {
        assertNotNull(PlanePhotoFactory.getInstance());;
    }
    
    /**
     *
     */
    @Test
    public void testCreatePhoto() {
        PlanePhoto planePhoto = PlanePhotoFactory.getInstance().createPhoto();
        assertNotNull(planePhoto);
    }

    /**
     *
     */
    @Test
    public void testCreatePhotoWithIds() {
        // Not Pennys Boat!
        PhotoId[] ids = new PhotoId[] {
            new PhotoId(4),
            new PhotoId(8),
            new PhotoId(15),
            new PhotoId(16),
            new PhotoId(23),
            new PhotoId(42),
        };

        for(PhotoId id : ids) {
            assertNotNull(PlanePhotoFactory.getInstance().createPhoto(id));
        }
    }

}
