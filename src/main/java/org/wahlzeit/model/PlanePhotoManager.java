package org.wahlzeit.model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanePhotoManager extends PhotoManager {
    
    /**
	 * 
	 */
	protected static final PlanePhotoManager instance = new PlanePhotoManager();
	
	/**
	 * 
	 */
	public static PlanePhotoManager getInstance() {
		return instance;
	}
	
	/**
	 * 
	 */
	public PlanePhotoManager() {
		super();
	}
	
	/**
	 * 
	 */
	protected PlanePhoto createObject(ResultSet rset) throws SQLException {
		return PlanePhotoFactory.getInstance().createPhoto(rset);
	}

    /**
	 * 
	 */
	public PlanePhoto createPhoto(File file) throws Exception {
		return (PlanePhoto) (super.createPhoto(file));
	}
}
