package com.konstantin;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits){
        this.locationID = locationID;
        this.description = description;
        if(exits != null)
            this.exits = new HashMap<String, Integer>(exits);
        else
            this.exits = new HashMap<String,Integer>();
        this.exits.put("Q", 0); //So that when you type Q, you are "At home"
    }

// because we've added the exits map in the constructor, we dont need an additional function to add an exit to the map:
//    public void addExit(String direction, int location){
//       exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
        //this way, we are returning a COPY of the Map exits and we cannot change its values!
    }
}
