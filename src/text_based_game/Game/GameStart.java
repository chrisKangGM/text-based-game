package text_based_game.Game;

import java.util.Scanner;

public class GameStart {
    
   /**
    * This is the initial interface when the game is executed.
    */
    public static void printGameStartScreen() {
        System.out.println("------------< The Mansion >-------------");
        System.out.println("|                                      |");
        System.out.println("| <1>   Game Start                     |");
        System.out.println("| <2>   How to play                    |");
        System.out.println("| <3>   About the version              |");
        System.out.println("|                                      |");
        System.out.println("| version 1.0              Chris Kang  |");
        System.out.println("----------------------------------------");
    }
    
   /**
    * gets the command of a user FROM the printGameStartScreen().
    * if 1: starts the game
    * if 2: shows how to play
    * if 3: shows about the version
    */
    public static void analyzeGameStartCommand(String userCommand, Scanner scan) {
        if (userCommand.equals("1")) {
            printGameStart();
        } else if (userCommand.equals("2")) {
            printHowToPlay();
        } else if (userCommand.equals("3")) {
            printAboutTheVersion();
        } else {
            System.out.println("Invalid Command. Press ENTER to continue");
        }
        scan.nextLine();
        
    }
    
   /**
    * prints the UI when the user starts the game.
    */
    public static void printGameStart() {
        System.out.println("--------------< The Mansion >--------------");
        System.out.println("-You woke up at the Entrance of a mansion.-");
        System.out.println("-You can smell something rotting and hear -");
        System.out.println("-eerie sound somewhere. You need to escape-");     
        System.out.println("-this creepy place.                       -");
        System.out.println("-                                         -");
        System.out.println("-commands: examine, north, south, east ...-");
        System.out.println("-         <PRESS ENTER TO START>          -");
        System.out.println("-------------------------------------------");
    }
    
   /**
    * prints the UI about HOW TO PLAY the game
    */
    public static void printHowToPlay() {
        System.out.println("------------< The Mansion >-------------");
        System.out.println("- Possible Commands (case insensitive) -");
        System.out.println("- EXAMINE: examines the room.          -");
        System.out.println("- NORTH/SOUTH/EAST/WEST:               -");
        System.out.println("- move to the specified direction      -");
        System.out.println("-                                      -");
        System.out.println("- Your GOAL is to reach to the EXIT.   -");
        System.out.println("-       <PRESS ENTER TO GO BACK>       -");
        System.out.println("----------------------------------------");
    }
    
   /**
    * prints the UI of about the author and the version of the game
    */
    public static void printAboutTheVersion() {
        System.out.println("------------< The Mansion >-------------");
        System.out.println("- Version: 1.0 (prototype)             -");
        System.out.println("- Author : Chris Kang                  -");
        System.out.println("- GitHub : github.com/chrisKangGM      -");
        System.out.println("-                                      -");
        System.out.println("- This project is for practice.        -");
        System.out.println("-                                      -");
        System.out.println("-       <PRESS ENTER TO GO BACK>       -");
        System.out.println("----------------------------------------");
    }
    
}