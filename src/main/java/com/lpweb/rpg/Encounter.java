package com.lpweb.rpg;

import java.util.Scanner;

import com.lpweb.rpg.entities.Entity;

public class Encounter {
    private Entity player;
    private Entity monster;

    public Encounter (Entity player, Entity monster) {
        this.player = player;
        this.monster = monster;
    }

    public boolean enter() {
        if (this.monster == null) {
            return true;
        }
        
        System.out.println("You encounter a monster. What do you want to do ?");
        this.displayActionList();

        Scanner scan = new Scanner(System.in);
        System.out.print("Action: ");
        boolean isActionValid = true;
        String action = scan.nextLine();

        do {
            switch (action) {
                case "1":
                    return this.fight();
                case "2":
                    return this.runAway();
                default:
                    System.err.println("Invalid action!");
                    isActionValid = false;
            }
        } while (!isActionValid);

        scan.close();
        return false;
    }

    public boolean fight() {
        System.out.println("|-----------|");
        System.out.println("|-- FIGHT --|");
        System.out.println("|-----------|");

        while (player.getLifePoints() != 0 && monster.getLifePoints() != 0) {
            System.out.println("Player: " + player.getLifePoints() + " lifepoints");
            System.out.println("Monster: " + monster.getLifePoints() + " lifepoints");

            monster.removeLifePoints(10);
        }

        return player.getLifePoints() > 0;
    }

    private void displayActionList() {
        System.out.println("• 1: fight");
        System.out.println("• 2: run away");
    }

    private boolean runAway() {
        System.out.println("You runned away.");
        return false;
    }
}
