package org.wahlzeit.model;

public class Plane {

    private PlaneType type; // 4 digit ICAO type code

    public Plane(PlaneType type) {
        this.type = type;
        assertClassInvariants();
    }

    public Plane(String type) {
        this.type = new PlaneType(type);
        assertClassInvariants();
    }

    /**
	 * 
	 * @methodtype get
	 */
    public PlaneType getAircraftType() {
        return type;
    }

    /**
	 * 
	 * @methodtype set
	 */
    public void setAircraftType(PlaneType type) {
        this.type = type;
        assertClassInvariants();
    }

    /**
	 * 
	 * @methodtype set
	 */
    public void setAircraftType(String type) {
        this.type = new PlaneType(type);
        assertClassInvariants();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if(!(other instanceof Plane)) return false;
        return this.type.equals(((Plane) other).getAircraftType());
    }

    public void assertClassInvariants() {
        if(this.type == null) throw new IllegalArgumentException("Plane must have a type");
    }
    
}
