package com.lpweb.rpg;

import java.util.Scanner;

import com.lpweb.rpg.entities.character.Character;

public class ConsoleRPG 
{
    /**
     * Player's character in the game.
     */
    private static Character player;

    /**
     * Map of the game
     */
    private static Map map;

    /**
     * Game scanner. Used to ask player actions in all the game.
     * Prevent to instanciate multiple scanner.
     */
    private static Scanner scanner;

    /**
     * Launch the game.
     * @param args
     */
    public static void main( String[] args )
    {
        scanner = new Scanner(System.in);

        Menu menu = Menu.getInstance();
        menu.displayWelcome();
        player = menu.chooseCharacter();

        map = new Map(30);
        map.render();

        // Play game while player is alive and has not win
        while (isPlayerAlive() && !isPlayerVictorious()) {
            String action = menu.askAction();

            if (menu.performAction(action)) {
                // Nothing to do when menu action succeeds
            }
            else if (map.performAction(action)) {
                // Rerender map when map action succeeds
                map.render();
            }
            else {
                System.err.println("Invalid action!");
            }
        }

        scanner.close();

        if (isPlayerVictorious())
            menu.displayWin();
        else
            menu.displayLose();

        scanner.close();
    }

    /**
     * Test if the player is victorious.
     * Player is victorious when positionned on the top right cell of the map.
     * @return boolean - Is the player victorious.
     */
    public static boolean isPlayerVictorious() {
        return
            map.getPlayerPosition().get("y") == 0 &&
            map.getPlayerPosition().get("x") == map.size() - 1;
    }

    /**
     * Test if the player is alive.
     * The player is considered alive while he has more than 0 lifepoints.
     * @return
     */
    public static boolean isPlayerAlive() {
        return ConsoleRPG.getPlayer().getLifePoints() > 0;
    }

    public static Character getPlayer() {
        return player;
    }

    public static Map getMap() {
        return map;
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
