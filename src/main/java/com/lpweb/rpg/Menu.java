package com.lpweb.rpg;

import java.util.Scanner;

public class Menu {
    private static final Menu instance = new Menu();

    public static Menu getInstance() {
        return instance;
    }

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

    public void displayHelp() {
        System.out.println("|---- List of actions ----|");
        this.displayActionList();
    }

    public String askAction(Scanner scan) {
        System.out.print("Action: ");
        String action = scan.nextLine();
        return action;
    }

    public boolean performAction(String action) {
        switch (action) {
            case "help":
                this.displayHelp();
                return true;
            default:
                return false;
        }
    }

    private void displayActionList() {
        System.out.println("• z:    move up");
        System.out.println("• s:    move down");
        System.out.println("• d:    move right");
        System.out.println("• q:    move left");
        System.out.println("• shop: open shop");
    }

    public void displayWin() {
        System.out.println("*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*");
        System.out.println("*! Congratulations, you won! !*");
        System.out.println("*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*");
    }

    public void displayLose() {
        System.out.println("#@#@#@#@#@#@#@#@#@#@#@#");
        System.out.println("#@ Oh no, game over! @#");
        System.out.println("#@#@#@#@#@#@#@#@#@#@#@#");
    }

    public void waitForEnter(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        scan.nextLine();
    }
}
