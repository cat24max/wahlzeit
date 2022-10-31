package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanePhoto extends Photo {

    private String type; // 4 digit ICAO type code
    private String airportLocation; // 3 digit IATA airport code where the photo was taken

    /**
	 * 
	 * @methodtype constructor
	 */
    public PlanePhoto() {
        super();
    }
	
	/**
	 * 
	 * @methodtype constructor
	 */
	public PlanePhoto(PhotoId myId) {
		super(myId);
	}
	
	/**
	 * 
	 * @methodtype constructor
	 */
	public PlanePhoto(ResultSet rset) throws SQLException {
		super(rset);
	}

    /**
	 * 
	 * @methodtype get
	 */
    public String getAircraftType() {
        return type;
    }
    
    /**
	 * 
	 * @methodtype get
	 */
    public String getAirportLocation() {
        return airportLocation;
    }

    /**
	 * 
	 * @methodtype set
	 */
    public void setAircraftType(String type) {
        this.type = type;
    }
    
    /**
	 * 
	 * @methodtype set
	 */
    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }
    
}