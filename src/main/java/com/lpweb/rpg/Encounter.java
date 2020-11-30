package com.lpweb.rpg;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.items.weapon.Weapon;

/**
 * Encounter between the player and a cell entity.
 */
public class Encounter {
    /**
     * Entity of the cell.
     */
    private Entity entity;

    public Encounter (Entity entity) {
        this.entity = entity;
    }

    /**
     * Enter the encounter.
     * Ask the player what to do.
     * @return boolean - Can the player move to the cell.
     */
    public boolean enter() {
        // If cell is empty player can move.
        if (this.entity == null) {
            return true;
        }
        
        // If cell is a invicible entity, player can not move.
        if (entity.isInvincible()) {
            return false;
        }

        // Otherwise, player must fight.
        System.out.println("You encounter a " + entity.getName() + ". What do you want to do ?");
        System.out.println("Your lifepoints: " + ConsoleRPG.getPlayer().getLifePoints());
        System.out.println(entity.getName() + ": " + entity.getLifePoints() + " lifepoints & " + entity.getDamages() + " damages");
        this.displayActionList();

        boolean isActionValid = true;
        
        do {
            // Ask action while player enters a invald action.
            System.out.print("Action: ");
            String action = ConsoleRPG.getScanner().nextLine();
            isActionValid = true;

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

        return false;
    }

    /**
     * Enter the fight.
     * @return boolean - Did the player win.
     */
    public boolean fight() {
        System.out.println("|-----------|");
        System.out.println("|-- FIGHT --|");
        System.out.println("|-----------|");

        // Fight while both player and entity are alive
        while (ConsoleRPG.getPlayer().getLifePoints() > 0 && entity.getLifePoints() > 0) {
            // Display round
            System.out.println("------------------");
            System.out.println("Player: " + ConsoleRPG.getPlayer().getLifePoints() + "/" + ConsoleRPG.getPlayer().getMaxLifepoints() + " lifepoints");
            System.out.println(entity.getName() + ": " + entity.getLifePoints() + " lifepoints");

            // Display player's weapons
            System.out.println("Attacks:");
            System.out.println("• 0: Fist - " + ConsoleRPG.getPlayer().getDamages() + " damages.");
            for (int i = 0; i < ConsoleRPG.getPlayer().getWeapons().size(); i++) {
                Weapon weapon = ConsoleRPG.getPlayer().getWeapons().get(i);
                System.out.println("• " + (i+1) + ": " + weapon.getName() + " - " + ConsoleRPG.getPlayer().getDamageWith(weapon) + " damages.");
            }

            // Ask player wich weapon to use
            System.out.print("Choose weapon: ");

            try {
                int weaponIndex = Integer.parseInt(ConsoleRPG.getScanner().nextLine()) - 1;

                // If choice is -1, attack with default weapon (fist)
                if (weaponIndex == -1) {
                    ConsoleRPG.getPlayer().attack(entity);
                }
                // Else use weapon of index weaponIndex
                else {
                    Weapon selectedWeapon = ConsoleRPG.getPlayer().getWeapons().get(weaponIndex);
                    ConsoleRPG.getPlayer().attack(entity, selectedWeapon);
                }

                // If entity is still alive, attack player
                if (entity.getLifePoints() > 0) {
                    entity.attack(ConsoleRPG.getPlayer());
                }
            } catch (Exception e) {
                System.out.println("Invalid weapon!");
            }
        }

        // Player wins if he is still alive
        if (ConsoleRPG.getPlayer().getLifePoints() > 0) {
            ConsoleRPG.getPlayer().addGold(entity.getReward());
            System.out.println("You won the fight!");
            return true;
        }
        else {
            System.out.println("You lost the fight...");
            return false;
        }
    }

    /**
     * Cancel the fight. Player will not be able to move to the cell.
     * @return boolean - Can player move to the cell.
     */
    private boolean runAway() {
        System.out.println("You runned away.");
        return false;
    }

    /**
     * Display the fight availables actions.
     */
    private void displayActionList() {
        System.out.println("• 1: fight");
        System.out.println("• 2: run away");
    }
}
