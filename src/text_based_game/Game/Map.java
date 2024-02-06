package text_based_game.Game;
/*
 * This Class is designated to create bunch of rooms.
 * You can add another map with the "Room" Object.
 */
public class Map {
    
   /**
    * This method is a DEFAULT (Mansion) map. For future versions, initialization can be done here for bigger map.
    * returns the initial position of the player, which is the ENTRANCE.
    * Below is the visual representation of the Mansion Map. 
    * (L) Stands for LOCKED, (K) Stands for KEY
    *
    *                     (L)EXIT
    *                         |
    * (L)DRESSROOM(K) - UPPER CORRIDOR
    *                         |
    *                    MID CORRIDOR - DINING ROOM
    *                         |             |
    *        VERANDA - LOWER CORRIDOR - GREAT HALL - BATHROOM(K)
    *                                       |
    *                                    ENTRANCE
    *
    * @return Room ENTRANCE
    */
    public static Room loadMansionMap() {
        Key AntiqueKey = new Key("Antique Key", "Dressroom", "You opened the hidden drawer and found a Antique Key!");
        Key ExoticKey  = new Key("Exotic Key", "Exit", "You searched the blazer's pocket, and found an Exotic Key!");
        
        Room ENTRANCE       = new Room("entrance", "You are on the entrance of a fancy mansion.\nThe door behind you seems to be locked.");                          
        Room GREAT_HALL     = new Room("Great Hall", "A big hall with a chandelier hanging on the ceiling.\nThe hall reminds you of French Renaissance with scupltures of myths.");
        Room BATHROOM       = new Room("Bathroom", false, "The tiles are full of stinky, black goo.\nGlass from the mirror is shattered, revealing a hidden drawer.", AntiqueKey);
        Room CORRIDOR_ONE   = new Room("Lower Corridor", "A long, relatively narrow corridor leading to somewhere.\nThe carpet is stained with brown liquid.");
        Room CORRIDOR_TWO   = new Room("Mid Corridor", "Some paintings are barely hanging on the wall.\nLooks quite expensive to me.");
        Room CORRIDOR_THREE = new Room("Upper Corridor", "Big, Exotic looking door overwhelms you.\nThis part of corridor looks antique.");
        Room DRESSROOM      = new Room("Dressroom", true, "Stains of bloods on formal clothes.\nIn the middle of the room lies a grey blazer.", ExoticKey);
        Room DINING_ROOM    = new Room("Dining Hall", "Quite a big table, would probably fit 10 people.\nSinks are stinky and the floor full of shattered glasses.");
        Room VERANDA        = new Room("Veranda", "Blood moon sheds light on you, and below lies darkness.\nThis mansion must be built on a cliff.");
        Room EXIT           = new Room("Exit", true, "You can feel the wind from outside, you've reached the exit!");
        
        ENTRANCE.north = GREAT_HALL;
        
        GREAT_HALL.south = ENTRANCE;
        GREAT_HALL.east  = BATHROOM;
        GREAT_HALL.north = DINING_ROOM;
        GREAT_HALL.west  = CORRIDOR_ONE;
        
        BATHROOM.west = GREAT_HALL;
        
        DINING_ROOM.south = GREAT_HALL;
        DINING_ROOM.west  = CORRIDOR_TWO;
        
        CORRIDOR_ONE.east  = GREAT_HALL;
        CORRIDOR_ONE.west  = VERANDA;
        CORRIDOR_ONE.north = CORRIDOR_TWO;
        
        VERANDA.east = CORRIDOR_ONE;
        
        CORRIDOR_TWO.south = CORRIDOR_ONE;
        CORRIDOR_TWO.east  = DINING_ROOM;
        CORRIDOR_TWO.north = CORRIDOR_THREE;
        
        CORRIDOR_THREE.south = CORRIDOR_TWO;
        CORRIDOR_THREE.west  = DRESSROOM;
        CORRIDOR_THREE.north = EXIT;
        
        DRESSROOM.east = CORRIDOR_THREE;
        
        EXIT.south = CORRIDOR_TWO;
        
        return ENTRANCE;
    }
    
}
