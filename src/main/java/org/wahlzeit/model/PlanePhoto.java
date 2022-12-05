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
		assertClassInvariants();
    }
	
	/**
	 * 
	 * @methodtype constructor
	 */
	public PlanePhoto(PhotoId myId) {
		super(myId);
		assertClassInvariants();
	}
	
	/**
	 * 
	 * @methodtype constructor
	 */
	public PlanePhoto(ResultSet rset) throws SQLException {
		super(rset);
		assertClassInvariants();
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
		assertValidAircraftType(type);
        this.type = type;
    }
    
    /**
	 * 
	 * @methodtype set
	 */
    public void setAirportLocation(String airportLocation) {
		assertValidIATACode(airportLocation);
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
		assertClassInvariants();
	}
	
	/**
	 * 
	 */
    @Override
	public void writeOn(ResultSet rset) throws SQLException {
		assertClassInvariants();
        super.writeOn(rset);
		rset.updateString("plane_type", this.type);
		rset.updateString("plane_airport_location", this.airportLocation);
	}

	public void assertValidAircraftType(String type) {
		if(type != null && (type.length() != 4 && type.length() != 3)) throw new IllegalArgumentException("Plane type is not a valid ICAO type designator ");
	}

	public void assertValidIATACode(String airportLocation) {
		if(type != null && airportLocation.length() != 3) throw new IllegalArgumentException("airportLocation is not valid");
	}

	public void assertClassInvariants() {
		super.assertClassInvariants();
		assertValidAircraftType(this.type);
		assertValidIATACode(this.airportLocation);
	}
}