package com.lpweb.rpg;

import com.lpweb.rpg.entities.character.Character;
import com.lpweb.rpg.entities.character.characters.*;

/**
 * Main game menu. Used by the player when in no other menu.
 * Used for main actions such as opening the shop, moving on the map...
 * Menu is unique for the game.
 */
public class Menu {
    /**
     * Instance of the menu (singleton)
     */
    private static final Menu instance = new Menu();

    public static Menu getInstance() {
        return instance;
    }

    /**
     * Display game welcome message and wqit for enter.
     */
    public void displayWelcome() {
        System.out.println("|-----------------------------|");
        System.out.println("|-- Welcome to Console RPG! --|");
        System.out.println("|-----------------------------|");
        System.out.println("Available actions are :");
        this.displayActionList();
        System.out.println("You can display again this list anytime by typing 'help'.");
        this.waitForEnter("Ready ? Press enter to begin!");
        System.out.flush();
    }

    /**
     * Display a presentation of all the characters and ask wich one the player
     * wants to play.
     * @return Character - Character chosen by the player.
     */
    public Character chooseCharacter() {
        System.out.println("---- First, choose your character ----");
        Dwarf.displayPresentation();
        Elfe.displayPresentation();
        Wizard.displayPresentation();

        System.out.println();
        System.out.println("• 1: Dwarf");
        System.out.println("• 2: Elfe");
        System.out.println("• 3: Wizard");

        while (true) {
            System.out.print("Wich character do you want to play? ");
            String choice = ConsoleRPG.getScanner().nextLine();
    
            if (choice.equals("1")) {
                return new Dwarf();
            }
            if (choice.equals("2")) {
                return new Elfe();
            }
            if (choice.equals("3")) {
                return new Wizard();
            }
            else {
                System.err.println("Invalid character.");
            }
        }
    }

    /**
     * Display the list of availables commands.
     */
    public void displayHelp() {
        System.out.println("|---- List of actions ----|");
        this.displayActionList();
        System.out.println("|-------------------------|");
    }

    /**
     * Ask player to enter an action.
     * @return
     */
    public String askAction() {
        System.out.println(ConsoleRPG.getPlayer().getLifePoints() + "/" + ConsoleRPG.getPlayer().getMaxLifepoints() + " lifepoints | " + ConsoleRPG.getPlayer().getGold() + " gold");
        System.out.print("Action: ");
        String action = ConsoleRPG.getScanner().nextLine();
        return action;
    }

    /**
     * Perform a menu action.
     * @param action - Action to perform.
     * @return boolean - Action succeeds.
     */
    public boolean performAction(String action) {
        switch (action) {
            case "help":
                this.displayHelp();
                return true;
            case "shop":
                Store.getInstance().enter();
                ConsoleRPG.getMap().render();
                return true;
            default:
                return false;
        }
    }

    /**
     * Display the list of availables actions.
     */
    private void displayActionList() {
        System.out.println("• z:    move up");
        System.out.println("• s:    move down");
        System.out.println("• d:    move right");
        System.out.println("• q:    move left");
        System.out.println("• shop: open shop");
        System.out.println("• help: display this list again");
    }

    /**
     * Display the win message.
     */
    public void displayWin() {
        System.out.println("*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*");
        System.out.println("*! Congratulations, you won! !*");
        System.out.println("*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*");
    }

    /**
     * Display the game over message.
     */
    public void displayLose() {
        System.out.println("#@#@#@#@#@#@#@#@#@#@#@#");
        System.out.println("#@ Oh no, game over! @#");
        System.out.println("#@#@#@#@#@#@#@#@#@#@#@#");
    }

    /**
     * Wait the player to press 'enter'.
     * @param message
     */
    public void waitForEnter(String message) {
        System.out.println(message);
        ConsoleRPG.getScanner().nextLine();
    }
}
