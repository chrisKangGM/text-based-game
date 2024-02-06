package text_based_game.UnitTest;

import text_based_game.Game.Key;
import text_based_game.Game.Room;

public class TestKey {
    
   /**
    * The main method that contains all UNIT TESTS of TestKey.
    * This method will be executed in MainTestFile.
    */
    public static void testKey() {
        System.out.println("-----<   testKey() executed     >-----");
        testKeyConstructor();
        testCanOpen();
        System.out.println();
    }
    
  
   /**
    * A single method testing both Key() default constructor,
    * and one Key() overloaded constructor
    * CASE #1: Key() default constructor
    * CASE #2: Key(String name, String purpose, String descriptionWhenFound) overloaded constructor
    */
    public static void testKeyConstructor() { 
        String methodName = "testKeyConstructor";
        boolean allTestsPassed = true;
            
        { //CASE #1: testing if the DEFAULT CONSTRUCTOR works properly.
            Key keyForTest = new Key();

            if (!Testing.actualMatchesExpected(keyForTest.name, "no name")) {
                Testing.printErrorMessage("testKeyConstructor(), Case #1, name", keyForTest.name, "no name");
                allTestsPassed = false;
            }
            
            if (!Testing.actualMatchesExpected(keyForTest.purpose, "no purpose")) {
                Testing.printErrorMessage("testKeyConstructor(), Case #1, purpose", keyForTest.purpose, "no purpose");
                allTestsPassed = false;
            }
            
            if (!Testing.actualMatchesExpected(keyForTest.descriptionWhenFound, "no description")) {
                Testing.printErrorMessage("testKeyConstructor(), Case #1, descriptionWhenFound", keyForTest.descriptionWhenFound, "no description");
                allTestsPassed = false;
            }
        }
        { //CASE #2: testing if the OVERLOADED CONSTRUCTOR works properly.
            Key keyForTest = new Key("has name", "has purpose", "has description");
            
            if (!Testing.actualMatchesExpected(keyForTest.name, "has name")) {
                Testing.printErrorMessage("testKeyConstructor(), Case #2, name", keyForTest.name, "has name");
                allTestsPassed = false;
            }
            
            if (!Testing.actualMatchesExpected(keyForTest.purpose, "has purpose")) {
                Testing.printErrorMessage("testKeyConstructor(), Case #2, purpose", keyForTest.purpose, "has purpose");
                allTestsPassed = false;
            }
            
            if (!Testing.actualMatchesExpected(keyForTest.descriptionWhenFound, "has description")) {
                Testing.printErrorMessage("testKeyConstructor(), Case #2, descriptionWhenFound", keyForTest.descriptionWhenFound, "has description");
                allTestsPassed = false;
            }
        }
        
        if (allTestsPassed) {
            Testing.printAllTestsPassed(methodName);
        }
    }
    
   /**
    * tests Room.canOpen, which returns true if the Key's purpose equals the Room's name
    *    false if not.
    * CASE #1: if the Key can open the Room (the Key.purpose equals Room.name)
    * CASE #2: if the Key CAN'T open the Room (the Key.purpose does not equal Room.name)
    */
    public static void testCanOpen() {
        //                Key(name, purpose, descripion)
        Key testKey = new Key("test key", "testing room", "this is description"); 
        boolean expected;
        boolean actual;
        boolean allTestsPassed = true;
        int caseNumber = 1;

        String methodName = "testCanOpen";
        
        {  //CASE #1: if the Key.purpose can open the specified room
            Room openableRoom = new Room("testing room", "this room can be opened with testKey");  //Room(name, description)  
            
            expected = true;
            actual   = testKey.canOpen(openableRoom);
            
            if (!Testing.actualMatchesExpected(actual, expected)) {
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {  //CASE #2: if the Key.purpose CAN'T open the specified room
            Room unopenableRoom = new Room("unopenable room", "this room can't be opened with testKey.");          
            
            expected = false;
            actual   = testKey.canOpen(unopenableRoom);
            
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
    
    
    
}