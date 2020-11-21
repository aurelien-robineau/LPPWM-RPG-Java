package com.lpweb.rpg;

import java.util.Scanner;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.character.characters.Dwarf;
import com.lpweb.rpg.map.Map;

public class App 
{
    public static void main( String[] args )
    {
        Entity player = new Dwarf();
        Menu menu = Menu.getInstance();
        Map map = new Map(30, player);
        menu.displayWelcome();
        map.render();
        Scanner scan = new Scanner(System.in);
        while (!map.playerWins()) {
            String action = menu.askAction(scan);

            if (menu.performAction(action)) {
                // Nothing to do
            }
            else if (map.performAction(action)) {
                map.render();
            }
            else {
                System.err.println("Invalid action!");
            }
        }
        scan.close();

        menu.displayWin();
    }
}
