package text_based_game.UnitTest;

import java.util.ArrayList;
import text_based_game.Game.Key;
import text_based_game.Game.Print;


public class TestPrint {
    
    public static void testPrint() {
        System.out.println("-----<   testPrint() executed   >-----");
        testGetInventoryToString();
        
        System.out.println();
    }

    public static void testGetInventoryToString() {
        final String methodName = "testGetInventoryToString";
        boolean allTestsPassed = true;
        int caseNumber = 1;
        
        String expected;
        String actual;
        
        { //CASE #1: when the testInventory is Empty
            ArrayList<Key> emptyArrayList = new ArrayList<>();
            expected = "empty";
            actual   = Print.getInventoryToString(emptyArrayList);
            
            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {  //CASE #2: when testInventory has 1 item
            ArrayList<Key> oneElementArrayList = new ArrayList<>();
            oneElementArrayList.add(new Key("first key", "bathroom", ""));
            
            expected = "first key";
            actual   = Print.getInventoryToString(oneElementArrayList);

            if (!Testing.actualMatchesExpected(actual, expected)) { 
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {  //CASE #3: when testInventory has 2 items
            ArrayList<Key> twoElementsArrayList = new ArrayList<>();
            twoElementsArrayList.add(new Key("first key", "bathroom", ""));
            twoElementsArrayList.add(new Key("second key", "toilet", ""));
            
            expected = "first key, second key";
            actual   = Print.getInventoryToString(twoElementsArrayList);

            if (!Testing.actualMatchesExpected(actual, expected)) {
                Testing.printErrorMessage(methodName, caseNumber, actual, expected);
                allTestsPassed = false;
            }
            caseNumber++;
        }
        {  //CASE #4: when testInventory has more than 3 items (4 items, in this case)
            ArrayList<Key> fourElementsArrayList = new ArrayList<>();
            fourElementsArrayList.add(new Key("first key", "bathroom", ""));
            fourElementsArrayList.add(new Key("second key", "toilet", ""));
            fourElementsArrayList.add(new Key("third key", "washroom", ""));
            fourElementsArrayList.add(new Key("fourth key", "restroom", ""));
            
            expected = "first key, second key, third key, fourth key";
            actual   = Print.getInventoryToString(fourElementsArrayList);

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