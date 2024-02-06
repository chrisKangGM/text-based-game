package text_based_game.UnitTest;

import java.util.ArrayList;
import text_based_game.Game.Room;
import text_based_game.Game.Key;
import text_based_game.Game.Print;

public class TestRoom {
   /**
    * The main method that contains all UNIT TESTS of TestRoom.
    * This method will be executed in MainTestFile.
    */
    public static void testRoom() {
        System.out.println("-----<   testRoom() executed    >-----");
        testRoomDefaultConstructor();
        testRoomOverloadedConstructor();
        testHasKey();
        testAddKeyToInventory(); 
        System.out.println();
    }
    
   /**
   * This method prints the error message of testAddKeyToInventory() method.
   * Unlike the predefined printErrorMessage() method in Testing class,
   * this is specifically for testAddKeyToInventory, because it has to print 
   * both inventory and the Room's availableKey.
   *
   * @param methodName: for printing which method had an error
   * @param caseNumber: for printing which case had an error
   * @param inventoryExpected: String of expected inventory, from executing getInventoryToString method
   * @param inventoryActual  : String of actual inventory
   * @param availableKeyExpected: the expected Reference of Room.availableKey
   * @param availableKeyActual  : the actual reference of Room.availableKey
   */
    public static void addKeyToInventoryPrintErrorMessage(String methodName, int caseNumber, String inventoryExpected, String inventoryActual, Key availableKeyExpected, Key availableKeyActual) {
        System.out.println("ERROR: " + methodName + ", CASE #" + caseNumber + " FAILED.");
        System.out.println("   inventory expected: " + inventoryExpected);
        System.out.println("   inventory actual  : " + inventoryActual);
        System.out.println("   availableKey EXPECTED: " + availableKeyExpected);
        System.out.println("   availableKey ACTUAL  : " + availableKeyActual);
    }
    
   /**
   * TESTS Room.hasKey() method, which returns 'true' if Room.availableKey != null
   *    but 'false' if Room.availableKey == null
   * CASE #1: if the room has no Key (if the Room.availableKey == null)
   * CASE #2: if the room has a Key made with default constructor
   * CASE #3: if the room has a Key made with overloaded constructor
   */
    public static void testHasKey() {
        String methodName = "testHasKey";
        boolean allTestsPassed = true;
        int caseNumber = 1;
        
        boolean expected;
        boolean actual;
        
        { //CASE #1: if the room has no key
            Room testRoom = new Room(); //this room has no key (key = null)
            
            expected = false;
            actual   = testRoom.hasKey();
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        { //CASE #2: if the room has a Default Key
            Room testRoom = new Room(); //this room has no key (key = null)
            testRoom.availableKey = new Key();
            
            expected = true;
            actual   = testRoom.hasKey();
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        { //CASE #2: if the room has a defined Key
            Room testRoom = new Room(); //this room has no key (key = null)
            testRoom.availableKey = new Key("new key", "new purpose", "new description when found");
            
            expected = true;
            actual   = testRoom.hasKey();
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        
    
        if (allTestsPassed) {
            Testing.printAllTestsPassed(methodName);
        }
    }
    
   /**
    * Tests Room.addKeyToInventory(ArrayList<Key> inventory)
    * Note: this method, when error occurs, prints both inventory expected/actual, 
    *  and availableKey expected/actual, and thus uses addKeyToInventoryPrintErrorMessage()
    *  for printing the error message. 
    * This is because addKeyToInventory performs both adding the key to inventory and removing the key
    * from the room.
    *
    * CASE #1: if the Room has no Key (Room.availableKey == null)
    * CASE #2: if the Room has a default Key (Key made with default constructor)
    * CASE #3: if the Room has a user-defined Key (Key made with overloaded constructor)
    * CASE #4: This case adds 7 keys to the inventory consecutively, all with user-defined Key.
    */
    public static void testAddKeyToInventory() {
        String methodName = "testAddKeyToInventory";
        boolean allTestsPassed = true;
        int caseNumber = 1;

        ArrayList<Key> inventory = new ArrayList<>();
        
        String inventoryExpected; 
        String inventoryActual;
        Key availableKeyExpected; //the Room has to have no Key after addKeyToInventory
        Key availableKeyActual;
        
        {   //CASE #1: if a Key trying to add is "NULL"
            Room testRoomOne = new Room();  //by default, testRoom has a null Key
            testRoomOne.addKeyToInventory(inventory);
            
            inventoryExpected = "empty";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomOne.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                allTestsPassed = false;
            }
            inventory.clear();
            caseNumber++;
        } 
        {   //CASE #2: if a Key is "Default Key"
            Room testRoomTwo = new Room();
            testRoomTwo.availableKey = new Key();
            testRoomTwo.addKeyToInventory(inventory);
            
            inventoryExpected = "no name";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomTwo.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                allTestsPassed = false;
            }
            inventory.clear();
            caseNumber++;
        }
        {   //CASE #3: if a Key trying to add is "defined Key"
            Room testRoomThree = new Room();
            testRoomThree.availableKey = new Key("testRoom Key", "purpose", "description");
            testRoomThree.addKeyToInventory(inventory);
            
            inventoryExpected = "testRoom Key";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomThree.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                allTestsPassed = false;
            }
            inventory.clear();
            caseNumber++;
        }
        {   //CASE #4: if 3 Keys are added to inventory flawlessly
            Room testRoomFour = new Room();
            testRoomFour.availableKey = new Key("first key", "", "");
            testRoomFour.addKeyToInventory(inventory);
            
            inventoryExpected = "first key";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomFour.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                System.out.println("   Error occured while adding the \"first key.\"");
                allTestsPassed = false;
            }
            
            testRoomFour.availableKey = new Key("second key", "", "");
            testRoomFour.addKeyToInventory(inventory);
            
            inventoryExpected = "first key, second key";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomFour.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                System.out.println("   Error occured while adding the \"second key.\"");
                allTestsPassed = false;
            }
            
            testRoomFour.availableKey = new Key("third key", "", "");
            testRoomFour.addKeyToInventory(inventory);
            
            inventoryExpected = "first key, second key, third key";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomFour.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                System.out.println("   Error occured while adding the \"third key.\"");
                allTestsPassed = false;
            }
            
            testRoomFour.availableKey = new Key("fourth key", "", "");
            testRoomFour.addKeyToInventory(inventory);
            
            inventoryExpected = "first key, second key, third key, fourth key";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomFour.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                System.out.println("   Error occured while adding the \"fourth key.\"");
                allTestsPassed = false;
            }
            
            testRoomFour.availableKey = new Key("fifth key", "", "");
            testRoomFour.addKeyToInventory(inventory);
            
            inventoryExpected = "first key, second key, third key, fourth key, fifth key";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomFour.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                System.out.println("   Error occured while adding the \"fifth key.\"");
                allTestsPassed = false;
            }
            
            testRoomFour.availableKey = new Key("sixth key", "", "");
            testRoomFour.addKeyToInventory(inventory);
            
            inventoryExpected = "first key, second key, third key, fourth key, fifth key, sixth key";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomFour.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                System.out.println("   Error occured while adding the \"sixth key.\"");
                allTestsPassed = false;
            }
            
            testRoomFour.availableKey = new Key("seventh key", "", "");
            testRoomFour.addKeyToInventory(inventory);
            
            inventoryExpected = "first key, second key, third key, fourth key, fifth key, sixth key, seventh key";
            inventoryActual   = Print.getInventoryToString(inventory);
            availableKeyExpected = null;
            availableKeyActual   = testRoomFour.availableKey;
            
            if (!Testing.actualMatchesExpected(inventoryActual, inventoryExpected)
               || availableKeyExpected != availableKeyActual) { 
                addKeyToInventoryPrintErrorMessage(methodName, caseNumber, inventoryExpected, inventoryActual, availableKeyExpected, availableKeyActual);
                System.out.println("   Error occured while adding the \"seventh key.\"");
                allTestsPassed = false;
            }
        }
    
        if (allTestsPassed) {
            Testing.printAllTestsPassed(methodName);
        }
    }
    
   /**
    * Tests Room(), the default constructor.
    * This tests only if the default constructor behaves in and expected way,
    * so there are no different cases for testing.
    */
    public static void testRoomDefaultConstructor() {
        String methodName = "testRoomDefaultConstructor";
        boolean allTestsPassed = true;

        {   //Testing Room Default Constructor
            Room testRoom = new Room();

            //Room.name
            String stringExpected = "no name";
            String stringActual   = testRoom.name;

            if (!Testing.actualMatchesExpected(stringActual, stringExpected)) { 
                Testing.printErrorMessage(methodName, stringActual, stringExpected);
                allTestsPassed = false;
            }

            //Room.isLocked
            boolean booleanExpected = false;
            boolean booleanActual   = testRoom.isLocked;

            if (!Testing.actualMatchesExpected(booleanExpected, booleanActual)) { 
                Testing.printErrorMessage(methodName, booleanExpected, booleanActual);
                allTestsPassed = false;
            }

            //Room.description
            stringExpected = "no description";
            stringActual   = testRoom.description;

            if (!Testing.actualMatchesExpected(stringActual, stringExpected)) { 
                Testing.printErrorMessage(methodName, stringActual, stringExpected);
                allTestsPassed = false;
            }

            //Room.availableKey (Object Key)
            Key keyExpected = null;
            Key keyActual   = testRoom.availableKey;

            if (keyActual != keyExpected) { 
                System.out.println("ERROR: " + methodName + ", availableKey FAILED.");
                System.out.println("   EXPECTED: " + keyExpected);
                System.out.println("   ACTUAL  : " + keyActual);
                allTestsPassed = false;
            }

            //Room.north (Room Object)
            Room roomExpected = null;
            Room roomActual   = testRoom.north;

            if (roomActual != roomExpected) { 
                System.out.println("ERROR: " + methodName + ", north does not match with expected result.");
                System.out.println("   EXPECTED: " + roomExpected);
                System.out.println("   ACTUAL  : " + roomActual);
                allTestsPassed = false;
            }

            //Room.east
            roomActual = testRoom.east;

            if (roomActual != roomExpected) { 
                System.out.println("ERROR: " + methodName + ", east does not match with expected result.");
                System.out.println("   EXPECTED: " + roomExpected);
                System.out.println("   ACTUAL  : " + roomActual);
                allTestsPassed = false;
            }

            //Room.south
            roomActual = testRoom.south;

            if (roomActual != roomExpected) { 
                System.out.println("ERROR: " + methodName + ", south does not match with expected result.");
                System.out.println("   EXPECTED: " + roomExpected);
                System.out.println("   ACTUAL  : " + roomActual);
                allTestsPassed = false;
            }

            //Room.south
            roomActual = testRoom.west;

            if (roomActual != roomExpected) { 
                System.out.println("ERROR: " + methodName + ", west does not match with expected result.");
                System.out.println("   EXPECTED: " + roomExpected);
                System.out.println("   ACTUAL  : " + roomActual);
                allTestsPassed = false;
            }
        }

        if (allTestsPassed) {
            Testing.printAllTestsPassed(methodName);
        }
    }
    
   /**
    * Tests Room()'s 3 overloaded Constructor, namely
    * CASE #1: Room(String name, String description)
    * CASE #2: Room(String name, boolean isLocked, String description)
    * CASE #3: Room(String name, boolean isLocked, String description, Key availableKey)
    */
    public static void testRoomOverloadedConstructor() {
        String methodName = "testRoomOverloadedConstructor";
        boolean allTestsPassed = true;
        int caseNumber = 1;

        {   //CASE #1: Room(String name, String description)
            Room testRoom = new Room("new name", "new description");

            //Room.name
            String stringExpected = "new name";
            String stringActual   = testRoom.name;
            
            if (!Testing.actualMatchesExpected(stringActual, stringExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, stringActual, stringExpected);
                allTestsPassed = false;
            }
            
            //Room.description
            stringExpected = "new description";
            stringActual   = testRoom.description;
            
            if (!Testing.actualMatchesExpected(stringActual, stringExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, stringActual, stringExpected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {   //CASE #2: Room(String name, boolean isLocked, String description)
            Room testRoom = new Room("case#2 name", true, "case#2 description");

            //Room.name
            String stringExpected = "case#2 name";
            String stringActual   = testRoom.name;
            
            if (!Testing.actualMatchesExpected(stringActual, stringExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, stringActual, stringExpected);
                allTestsPassed = false;
            }
            
            //Room.isLocked
            boolean booleanExpected = true;
            boolean booleanActual   = testRoom.isLocked;

            if (!Testing.actualMatchesExpected(booleanExpected, booleanActual)) { 
                Testing.printErrorMessage(methodName, caseNumber, booleanExpected, booleanActual);
                allTestsPassed = false;
            }
            
            //Room.description
            stringExpected = "case#2 description";
            stringActual   = testRoom.description;
            
            if (!Testing.actualMatchesExpected(stringActual, stringExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, stringActual, stringExpected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {   //CASE #3: Room(String name, boolean isLocked, String description, Key availableKey)
            Key testKey = new Key("test key", "purpose", "description");
            Room testRoom = new Room("case#3 name", true, "case#3 description", testKey);

            //Room.name
            String stringExpected = "case#3 name";
            String stringActual   = testRoom.name;
            
            if (!Testing.actualMatchesExpected(stringActual, stringExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, stringActual, stringExpected);
                allTestsPassed = false;
            }
            
            //Room.isLocked
            boolean booleanExpected = true;
            boolean booleanActual   = testRoom.isLocked;

            if (!Testing.actualMatchesExpected(booleanExpected, booleanActual)) { 
                Testing.printErrorMessage(methodName, caseNumber, booleanExpected, booleanActual);
                allTestsPassed = false;
            }
            
            //Room.description
            stringExpected = "case#3 description";
            stringActual   = testRoom.description;
            
            if (!Testing.actualMatchesExpected(stringActual, stringExpected)) { 
                Testing.printErrorMessage(methodName, caseNumber, stringActual, stringExpected);
                allTestsPassed = false;
            }
            
            //Room.availableKey (Object Key)
            Key keyExpected = testKey;
            Key keyActual   = testRoom.availableKey;

            if (keyActual != keyExpected) { 
                System.out.println("ERROR: " + methodName + ", availableKey FAILED.");
                System.out.println("   EXPECTED: " + keyExpected);
                System.out.println("   ACTUAL  : " + keyActual);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        
        if (allTestsPassed) {
            Testing.printAllTestsPassed(methodName);
        }
    }
    
    
    
}