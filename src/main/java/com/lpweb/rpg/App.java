package com.lpweb.rpg;

import java.util.Scanner;

import com.lpweb.rpg.entities.character.Character;
import com.lpweb.rpg.entities.character.characters.Dwarf;
import com.lpweb.rpg.map.Map;

public class App 
{
    public static void main( String[] args )
    {
        Character player = new Dwarf();
        Menu menu = Menu.getInstance();
        Map map = new Map(30, player);
        menu.displayWelcome();
        map.render();
        Scanner scan = new Scanner(System.in);
        while (!map.playerWins() && !map.playerIsDead()) {
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

        if (map.playerIsDead())
            menu.displayLose();
        else
            menu.displayWin();
    }
}
