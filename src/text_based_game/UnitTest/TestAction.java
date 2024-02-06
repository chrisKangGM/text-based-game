package text_based_game.UnitTest;

import java.util.ArrayList;
import text_based_game.Game.Key;
import text_based_game.Game.Room;
import text_based_game.Game.Action;
import text_based_game.Game.Print;
import text_based_game.Game.Map;

public class TestAction {
    
   /**
    * The main method that contains all UNIT TESTS of TestAction.
    * This method will be executed in MainTestFile.
    */
    public static void testAction() {
        System.out.println("-----<   testAction() executed     >-----");
        testGoToTheRoom();
        testExecutePlayerCommand();
        
        System.out.println();
    }
    
  /**
   * Tests Action.executePlayerCommand, which returns the same room if you could not move,
   * or an updated room if you moved.
   * The test cases are not independent (meaning if case 1 fails, others will fail no matter what)
   * so not really a great testing method.
   */
    public static void testExecutePlayerCommand() {
        Room currentRoom = Map.loadMansionMap();  //currentRoom.name = "entrance"
        String methodName = "testExecutePlayerCommand";
        String playerCommand = "";
        ArrayList<Key> inventory = new ArrayList<>();
        boolean allTestsPassed = true;
        int caseNumber = 1;
            
        String expected;
        String actual;
        
        {   //CASE #1: when player command is "go north".
            playerCommand = "go north";
            currentRoom = Action.executePlayerCommand(playerCommand, currentRoom, inventory);
            
            expected = "Great Hall";  //north to the "entrance" is "Great Hall"
            actual   = currentRoom.name;
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {   //CASE #2: when player command is "go east".
            playerCommand = "go east";
            currentRoom = Action.executePlayerCommand(playerCommand, currentRoom, inventory);
            
            expected = "Bathroom";  //east to the "entrance" is "Great Hall"
            actual   = currentRoom.name;
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {   //CASE #3: when player command is "examine".
            playerCommand = "examine";
            currentRoom = Action.executePlayerCommand(playerCommand, currentRoom, inventory);
            
            //This part checks if the currentRoom changes or not
            expected = "Bathroom";  //east to the "entrance" is "Great Hall"
            actual   = currentRoom.name;
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            
            //This part checks if the inventory is updated with an "Antique Key"
            expected = "Antique Key";
            actual   = Print.getInventoryToString(inventory);
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {   //CASE #4: when player command is "go west".
            playerCommand = "go west";
            currentRoom = Action.executePlayerCommand(playerCommand, currentRoom, inventory);
            
            expected = "Great Hall";  //west to the "Bathroom" is "Great Hall"
            actual   = currentRoom.name;
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {   //CASE #4: when player command is "go south".
            playerCommand = "go south";
            currentRoom = Action.executePlayerCommand(playerCommand, currentRoom, inventory);
            
            expected = "entrance";  //west to the "Bathroom" is "Great Hall"
            actual   = currentRoom.name;
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {   //CASE #5: when player command is INVALID
            playerCommand = "this is invalid command";
            currentRoom = Action.executePlayerCommand(playerCommand, currentRoom, inventory);
            
            expected = "entrance";
            actual = currentRoom.name;
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
        }
        
        
        if (allTestsPassed) {
            Testing.printAllTestsPassed(methodName);
        }

        
    }
    
   /**
    * Tests Action.goToTheRoom, which checks if the destinationRoom is goable.
    * if locked or the destinationRoom does not exist, you player can't move.
    * if locked but player has a matching key, player unlocks the door (but doesn't move)
    * if the room is not locked and exists, the player moves.
    * CASE #1: destinationRoom does not exist (player)
    * CASE #2: destinationRoom is locked, and you don't have anything in your inventory
    * CASE #3: destinationRoom is locked and you have keys, but you don't have a matching key
    * CASE #4: destinationRoom is locked. in your inventory, you only have one key, which is a matching key.
    * CASE #5: destinationRoom is locked, in your inventory, you have four keys, where one of them is a matching key.
    * CASE #6: destinationRoom is not locked, and you can move.
    */
    public static void testGoToTheRoom() {
        ArrayList<Key> inventory = new ArrayList<>();
        String methodName = "testGoToTheRoom";
        boolean allTestsPassed = true;
        int caseNumber = 1;

        { //CASE #1: when the destinationRoom is null (cannot go to the room)
            Room destinationRoom = null;
            boolean booleanExpected;
            boolean booleanActual;
            
            System.out.println("** testGoToTheRoom(), CASE #1 **");
            System.out.println("Supposed to print: > You hit your nose on the wall, ouch!");
            System.out.print  ("Actually Printed : ");
            
            booleanExpected = false;
            booleanActual   = Action.goToTheRoom(destinationRoom, inventory);
            
            if (!Testing.actualMatchesExpected(booleanActual, booleanExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, booleanActual, booleanExpected);
                allTestsPassed = false;
            }
            System.out.println();
            caseNumber++;
        }
        { //CASE #2: when the destinationRoom is locked, and you don't have any key in the inventory (which means you can't open)
            Room destinationRoom = new Room("", true, "");
            boolean booleanExpected;
            boolean booleanActual;
            
            System.out.println("** testGoToTheRoom(), CASE #2 **");
            System.out.println("Supposed to print: > You try opening the door, but it seems to be locked.");
            System.out.print  ("Actually Printed : ");
            
            booleanExpected = false;
            booleanActual   = Action.goToTheRoom(destinationRoom, inventory);
            
            if (!Testing.actualMatchesExpected(booleanActual, booleanExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, booleanActual, booleanExpected);
                allTestsPassed = false;
            }
            System.out.println();
            caseNumber++;
        }
        { //CASE #3: when the destinationRoom is locked, and you don't have matching key in the inventory (can't open, but you have keys)
            Room destinationRoom = new Room("testing room", true, "");
            inventory.add(new Key("key 1", "test room", "can't open"));
            inventory.add(new Key("key 2", "best room", "can't open"));
            inventory.add(new Key("key 3", "west room", "can't open"));
            
            boolean booleanExpected;
            boolean booleanActual;
            
            System.out.println("** testGoToTheRoom(), CASE #3 **");
            System.out.println("Supposed to print: > You try opening the door, but it seems to be locked.");
            System.out.print  ("Actually Printed : ");
            
            booleanExpected = false;
            booleanActual   = Action.goToTheRoom(destinationRoom, inventory);
            
            if (!Testing.actualMatchesExpected(booleanActual, booleanExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, booleanActual, booleanExpected);
                allTestsPassed = false;
            }
            
            //Below checks if inventory changes or not.
            String inventoryExpected = "key 1, key 2, key 3";
            String inventoryActual   = Print.getInventoryToString(inventory);
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, inventoryActual, inventoryExpected);
                allTestsPassed = false;
            }
            
            System.out.println();
            inventory.clear();
            caseNumber++;
        }
        { //CASE #4: when (room can be opened, you have one matching key in inventory only)
            Room destinationRoom = new Room("testing room", true, "");
            inventory.add(new Key("matching key", "testing room", "can open"));
            
            boolean booleanExpected;
            boolean booleanActual;
            
            System.out.println("** testGoToTheRoom(), CASE #4 **");
            System.out.println("Supposed to print: > You opened the door with matching key!");
            System.out.print  ("Actually Printed : ");
            
            booleanExpected = false;
            booleanActual   = Action.goToTheRoom(destinationRoom, inventory);
            
            if (!Testing.actualMatchesExpected(booleanActual, booleanExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, booleanActual, booleanExpected);
                allTestsPassed = false;
            }
            
            //Below checks if inventory changes or not.
            String inventoryExpected = "empty";
            String inventoryActual   = Print.getInventoryToString(inventory);
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, inventoryActual, inventoryExpected);
                allTestsPassed = false;
            }
            
            System.out.println();
            caseNumber++;
        }
        { //CASE #5: when (room can be opened, you have one matching key and other keys in inventory)
            Room destinationRoom = new Room("testing room", true, "");
            inventory.add(new Key("key 1", "test room", "can't open"));
            inventory.add(new Key("key 2", "best room", "can't open"));
            inventory.add(new Key("key 3", "west room", "can't open"));
            inventory.add(new Key("matching key", "testing room", "can open"));
            
            boolean booleanExpected;
            boolean booleanActual;
            
            System.out.println("** testGoToTheRoom(), CASE #5 **");
            System.out.println("Supposed to print: > You opened the door with matching key!");
            System.out.print  ("Actually Printed : ");
            
            booleanExpected = false;
            booleanActual   = Action.goToTheRoom(destinationRoom, inventory);
            
            if (!Testing.actualMatchesExpected(booleanActual, booleanExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, booleanActual, booleanExpected);
                allTestsPassed = false;
            }
            
            //Below checks if inventory changes or not.
            String inventoryExpected = "key 1, key 2, key 3";
            String inventoryActual   = Print.getInventoryToString(inventory);
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, inventoryActual, inventoryExpected);
                allTestsPassed = false;
            }
            
            System.out.println();
            caseNumber++;
        }
        { //CASE #6: when (door is not locked, and you successfully moved)
            Room destinationRoom = new Room("destination room", "");
            boolean booleanExpected;
            boolean booleanActual;
            
            System.out.println("** testGoToTheRoom(), CASE #6 **");
            System.out.println("Supposed to print: > You walked to destination room.");
            System.out.print  ("Actually Printed : ");
            
            booleanExpected = true;
            booleanActual   = Action.goToTheRoom(destinationRoom, inventory);
            
            if (!Testing.actualMatchesExpected(booleanActual, booleanExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, booleanActual, booleanExpected);
                allTestsPassed = false;
            }
            System.out.println();
            caseNumber++;
        }

        if (allTestsPassed) {
            Testing.printAllTestsPassed(methodName);
        }
    }

}