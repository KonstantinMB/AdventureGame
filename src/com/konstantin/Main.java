package com.konstantin;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        //now, lets add some locations to the map:
        Map<String,Integer> tempExit = new HashMap<String,Integer>();
        locations.put(0, new Location(0, "At home",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("W", 2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        locations.put(1, new Location(1, "Lifting weights at the gym",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("N",5);
        locations.put(2, new Location(2, "Watching educational videos.",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("W",1);
        locations.put(3, new Location(3, "Going for a walk",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4, new Location(4, "At your villa",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5, new Location(5, "Chilling at the club",tempExit));

        // adding more types of inputs that the user can type in order to give his next location
        Map<String,String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("The available exits are ");
            for (String exit: exits.keySet()){
                System.out.print(exit + " ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1){
                String[] words = direction.split(" ");
                for (String word: words){
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word); //returns the value, in this case: Q W N S E
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }
            else{
                System.out.println("This direction is not available");
            }

        }

    }
}
