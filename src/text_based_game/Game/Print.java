package text_based_game.Game;

import java.util.Scanner;
import java.util.ArrayList;

public class Print {

   /**
    * Prints a char with a given length. 
    * EX)   printCharRepeatedly('a', 3)
    * THEN) aaa
    * @param charToPrint: A char to be printed
    * @param nTimes     : number of times the char will be printed out
    */
    public static void printCharRepeatedly(char charToPrint, int nTimes) {
        for (int i=0; i < nTimes; ++i) {
            System.out.print(charToPrint);
        }
        System.out.println();
    }
    
   /**
    * Dependent on getInventoryToString()
    * This method prints out the inventory.
    * if empty: "inventory: empty"
    * if not  : "inventory: item1, item2"
    */
    public static void printInventory(ArrayList<Key> inventory) {
        System.out.println("inventory: " + getInventoryToString(inventory));
    }
    
   /**
    * Used in printInventory()
    * This method returns the current Inventory in String.
    * This method is used in the printCurrentRoom() method.
    * EX)   inventory = {"1", "2", "3", "4"}
    * THEN) 1, 2, 3, 4
    *
    * @param ArrayList<Key> inventory : the inventory to return as String
    * @return String inventoryInString: the String iteration of inventory 
    */
    public static String getInventoryToString(ArrayList<Key> inventory) {
        String inventoryInString = "";
        int index;
        
        //Edge Case #1: if inventory is EMPTY
        if (inventory.size() == 0) {
            return "empty";
        }
        
        //Normal Case: if inventory contains more than 1 item
        for (index = 0; index < inventory.size() - 1; ++index) {
            inventoryInString += (inventory.get(index)).name + ", ";
        }
        inventoryInString += (inventory.get(index)).name;
        
        return inventoryInString;
    }
    
    
    
    
}