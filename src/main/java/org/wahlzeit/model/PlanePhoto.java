package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {
			"AbstractProduct"
		}
)
public class PlanePhoto extends Photo {

    private Plane plane; // 4 digit ICAO type code
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
    public String getAirportLocation() {
        return airportLocation;
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
	 * @methodtype get
	 */
    public Plane getAircraft() {
        return plane;
    }

    /**
	 * 
	 * @methodtype set
	 */
    public void setAircraftType(Plane plane) {
        this.plane = plane;
        assertClassInvariants();
    }

    /**
	 * 
	 */
    @Override
	public void readFrom(ResultSet rset) throws SQLException {
		super.readFrom(rset);
		this.plane = new Plane(rset.getString("plane_type"));
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
		rset.updateString("plane_type", this.plane.getAircraftType().getTypestring());
		rset.updateString("plane_airport_location", this.airportLocation);
	}


	public void assertValidIATACode(String airportLocation) {
		if(airportLocation != null && airportLocation.length() != 3) throw new IllegalArgumentException("airportLocation is not valid");
	}

	public void assertClassInvariants() {
		super.assertClassInvariants();
		assertValidIATACode(this.airportLocation);
	}
}