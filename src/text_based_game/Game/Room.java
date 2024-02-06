package text_based_game.Game;

import java.util.ArrayList;

public class Room {
    public String name;
    public boolean isLocked;
    public String description;
    public Key availableKey;
    public Room north;
    public Room east;
    public Room south;
    public Room west;
    
    //DEFAULT Constructor
    public Room() {
        name         = "no name";
        isLocked     = false;
        description  = "no description";
        availableKey = null;
        north = null;
        east  = null;
        south = null;
        west  = null;
    }
    
    //Overloaded Constructor (#2: String name, String description)
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    //Overloaded Constructor (#2: String name, boolean isLocked, String description)
    public Room(String name, boolean isLocked, String description) {
        this.name = name;
        this.isLocked = isLocked;
        this.description = description;
    }
    
    //Overloaded Constructor (#3 String name, boolean isLockec, String description, Key availableKey)
    public Room(String name, boolean isLocked, String description, Key availableKey) {
        this.name = name;
        this.isLocked = isLocked;
        this.description = description;
        this.availableKey = availableKey; 
    }
    
   /**
    * @return true : if the Room has an availableKey
    * @return false: if the Room has NO avaialableKey
    */
    public boolean hasKey() {
        if (availableKey == null) { return false; }
        else { return true; }
    }
    
    /**
    * adds the key in the room to the player's inventory.
    * if the key does not exist (if null), does nothing.
    */
    public void addKeyToInventory(ArrayList<Key> inventory) {
        if (availableKey != null) {
            inventory.add(availableKey);
            availableKey = null;
        }
    }

    
   /**
    * This method prints currentRoom's name, description, adjacent rooms.
    * example: currentRoom only has a Room "hall" to the north.
    *
    * Result: ------------------------------
    *         You are currently at < currentRoom >.
    *         <Room.description here>
    *        
    *         You see a hall to the NORTH.
    *         ------------------------------
    *
    * @param currentRoom: a room where the player is currently in.
    */
    public void printDescription() {
        
        System.out.println("You are currently at < " + name + " >.");
        System.out.println(description + "\n");
        
        //The following parts print what adjacent rooms are.
        if (north != null) {
            System.out.println("You see a " + north.name + " to the NORTH.");
        } if (east != null) {
            System.out.println("You see a " + east.name + " to the EAST.");
        } if (south != null) {
            System.out.println("You see a " + south.name + " to the SOUTH.");
        } if (west != null) {
            System.out.println("You see a " + west.name + " to the WEST.");
        }

    }
}