package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

public class PlaneManager extends ObjectManager {

    /**
	 * 
	 */
	protected static final PlaneManager instance = new PlaneManager();

    private Map<Integer, Plane> cache = new HashMap<>();
	
	/**
	 * 
	 */
	public static PlaneManager getInstance() {
		return instance;
	}
	
	/**
	 * 
	 */
	public PlaneManager() {
		super();
	}

    @Override
    protected Persistent createObject(ResultSet rset) throws SQLException {
        // TODO Auto-generated method stub
        // Not filled, because Plane doesn't do Persistence. If it would, this method would call "new Plane(rset)"
        return null;
    }

    public Plane createPlane(String typestring) {
        int hash = typestring.hashCode();
        if(cache.containsKey(hash)) {
            return cache.get(hash);
        }
        Plane newObject = new Plane(typestring);
        cache.put(hash, newObject);
        return newObject;
    }
    
}
