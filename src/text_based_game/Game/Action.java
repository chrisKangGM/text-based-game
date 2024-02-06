package text_based_game.Game;

import java.util.ArrayList;

public class Action {
    
 
   /**
    * Handles the following player command: "go north", "go east" "go south" "go west"
    *                                     "north", "east", "south", "west"
    * @param Room destinationRoom   : the room player is trying to go
    * @return boolean moveSuccessful: if the player successfully "go" to the room 
    *                                 (for updating the currentRoom)
    */
    public static boolean goToTheRoom(Room destinationRoom, ArrayList<Key> inventory) {
        boolean moveSuccessful = false;
        
        if (destinationRoom == null) {
            System.out.println("> You hit your nose on the wall, ouch!");
        } else if (destinationRoom.isLocked) {   
            int i;
            for (i=0; i < inventory.size(); ++i) {
                if (inventory.get(i).canOpen(destinationRoom)) {
                    System.out.println("> You opened the door with " + inventory.get(i).name + "!");
                    inventory.remove(i);
                    destinationRoom.isLocked = false;
                }
            }
            
            if (destinationRoom.isLocked) {
                System.out.println("> You try opening the door, but it seems to be locked.");
            }
        } else {
            System.out.println("> You walked to " + destinationRoom.name + ".");
            moveSuccessful = true;
        }
        
        return moveSuccessful;
    }
    
   /**
    * This method executes what the player has input from printPlayerCommandRequest() method.
    * Analyzes and Check if the player input is an executable command, 
    * and if yes, executes the command.
    *
    * @param String playerCommand: the command passed in from printPlayerCommandRequest() 
    * @param Room currentRoom    : the Room, a player is currently in, for the purpose of updating if applicable
    * @return Room roomAfterCommandExecution: the Room player is going the be at, after the command is executed
    */
    public static Room executePlayerCommand(String playerCommand, Room currentRoom, ArrayList<Key> inventory) {
        Room roomAfterCommandExecution = currentRoom;
        
        if (playerCommand.equals("go north") || playerCommand.equals("north")) {
            
            //if you were able to GO to NORTH
            if (goToTheRoom(currentRoom.north, inventory)) {
                roomAfterCommandExecution = currentRoom.north;
            }
            
        } else if (playerCommand.equals("go east") || playerCommand.equals("east")) {
            
            //if you were able to GO to EAST
            if (goToTheRoom(currentRoom.east, inventory)) {
                roomAfterCommandExecution = currentRoom.east;
            }
            
        } else if (playerCommand.equals("go south") || playerCommand.equals("south")) {
            
            //if you were able to GO to SOUTH
            if (goToTheRoom(currentRoom.south, inventory)) {
                roomAfterCommandExecution = currentRoom.south;
            }
            
        } else if (playerCommand.equals("go west") || playerCommand.equals("west")) {
            
            //if you were able to GO to the WEST
            if (goToTheRoom(currentRoom.west, inventory)) {
                roomAfterCommandExecution = currentRoom.west;
            }
            
        } else if (playerCommand.equals("examine") || playerCommand.equals("search")){
            
            if (currentRoom.hasKey()) {
                currentRoom.availableKey.printWhenKeyFound();
                currentRoom.addKeyToInventory(inventory);
            } else {
                System.out.println("> You tried to search, but you could not find anything notable.");
            }
            
        } else {
            
            System.out.println("> Your input is invalid. You didn't do anything.");
            
        }
        return roomAfterCommandExecution;
    }
    
}