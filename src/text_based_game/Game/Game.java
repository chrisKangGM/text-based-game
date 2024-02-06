package text_based_game.Game;

import java.util.Scanner;
import java.util.ArrayList;


public class Game {
   /**
    * this method returns the player's input command.
    * @return String: what player inputs
    */
    public static String getPlayerCommand(Scanner scan) {
        return scan.nextLine().toLowerCase();
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playerCommand = "";
        
        //GameStart.java (Game Start UI)
        while (!playerCommand.equals("1")) {
            GameStart.printGameStartScreen();
            playerCommand = getPlayerCommand(scan);
            GameStart.analyzeGameStartCommand(playerCommand, scan);
        }
        
        
        //From here, the actual game code
        boolean gameOngoing = true;
        
        ArrayList<Key> inventory = new ArrayList<>();
        Room currentRoom = Map.loadMansionMap();
        
        do {
            if (currentRoom.name.equals("Exit")) { 
                gameOngoing = false;
                System.out.println("You see an Exit! You escaped from the mansion!");
                break;
            }
            
            Print.printCharRepeatedly('-', 40);
            Print.printInventory(inventory);
            currentRoom.printDescription();
            Print.printCharRepeatedly('-', 40);
            
            System.out.print("What would you do: ");
            playerCommand = getPlayerCommand(scan);
            currentRoom   = Action.executePlayerCommand(playerCommand, currentRoom, inventory);
        } while (gameOngoing);
        
        System.out.println("-GAME OVER-");
    }
    
    
}