package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.services.SysLog;

/**
 * An Abstract Factory for creating plane photos and related objects.
 */
public class PlanePhotoFactory extends PhotoFactory {
    
    /**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static PlanePhotoFactory instance = null;
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized PlanePhotoFactory getInstance() {
		if (instance == null) {
			SysLog.logSysInfo("setting generic PlanePhotoFactory");
			setInstance(new PlanePhotoFactory());
		}
		
		return instance;
	}
	
	/**
	 * Method to set the singleton instance of PlanePhotoFactory.
	 */
	protected static synchronized void setInstance(PlanePhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize PlanePhotoFactory twice");
		}
		
		instance = photoFactory;
	}
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	/**
	 * 
	 */
	protected PlanePhotoFactory() {
        super();
		// do nothing
	}

	/**
	 * @methodtype factory
	 */
	public PlanePhoto createPhoto() {
		return new PlanePhoto();
	}
	
	/**
	 * 
	 */
	public PlanePhoto createPhoto(PhotoId id) {
		return new PlanePhoto(id);
	}
	
	/**
	 * 
	 */
	public Photo createPhoto(ResultSet rs) throws SQLException {
		return new Photo(rs);
	}
}
