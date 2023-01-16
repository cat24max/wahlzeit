package org.wahlzeit.model;

public class PlaneType {

    private PlaneType superType;

    private String type; // 4 digit ICAO type code
    
    public PlaneType(String type) {
        this.type = type;
        assertClassInvariants();
    }

    /**
	 * 
	 * @methodtype get
	 */
    public String getTypestring() {
        return type;
    }

    /**
	 * 
	 * @methodtype set
	 */
    public void setTypestring(String type) {
        this.type = type;
        assertClassInvariants();
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof PlaneType)) return false;
        return this.type.equals(((PlaneType) other).getTypestring());
    }

    public String getSupertype() {
        return this.type.substring(0, 3);
    }

    public boolean isSubtype(PlaneType other) {
        if(other == null) throw new IllegalArgumentException("Pot. Subtype cannot be null");
        return this.getSupertype().equals(other.getSupertype());
    }

    public void assertClassInvariants() {
        assertValidAircraftType(this.type);
    }

    public void assertValidAircraftType(String type) {
		if(type != null && (type.length() != 4 && type.length() != 3)) throw new IllegalArgumentException("Plane type is not a valid ICAO type designator ");
	}

}
