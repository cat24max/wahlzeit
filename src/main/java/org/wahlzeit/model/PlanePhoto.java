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

    /**
	 * 
	 */
    @Override
	public void readFrom(ResultSet rset) throws SQLException {
		super.readFrom(rset);
		this.type = rset.getString("plane_type");
        this.airportLocation = rset.getString("plane_airport_location");
	}
	
	/**
	 * 
	 */
    @Override
	public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
		rset.updateString("plane_type", this.type);
		rset.updateString("plane_airport_location", this.airportLocation);
	}
}