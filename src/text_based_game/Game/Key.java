package text_based_game.Game; 

/**
* Key Object Class stores the following:
* String name,    the name of the key, when printing out which key the player owns.
* String purpose, the room in which the key can be used to unlock.
*/
public class Key {
    public String name;
    public String purpose;
    public String descriptionWhenFound;
    
    //DEFAULT constructor
    public Key() {
        name = "no name";
        purpose = "no purpose";
        descriptionWhenFound = "no description";
    }
    
    //OVERLOADED CONSTRUCTOR
    public Key(String keyName, String purpose, String descriptionWhenFound) {
        name = keyName;
        this.purpose = purpose;
        this.descriptionWhenFound = descriptionWhenFound;
    }
    
   /**
    * this method checks is the key can be used to the Room.
    * returns true if it can be used to unlock, and false if it can't.
    *
    * @param Room roomToUnlock: the Room in which the player is trying to open with the key.
    * @return boolean, true if the key can be used, false if it can't be used.
    */
    public boolean canOpen(Room roomToUnlock) {
        if (purpose.equals(roomToUnlock.name)) {
            return true;
        } else {
            return false;
        }
    }
    
   /**
    * This method is used when the user "examine" and finds a key in the room.
    */
    public void printWhenKeyFound() {
        System.out.println(descriptionWhenFound);
    }
}