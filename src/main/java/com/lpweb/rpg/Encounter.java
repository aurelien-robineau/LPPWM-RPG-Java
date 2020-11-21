package com.lpweb.rpg;

import java.util.Scanner;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.character.Character;
import com.lpweb.rpg.weapon.Weapon;

public class Encounter {
    private Character player;
    private Entity monster;

    public Encounter (Character player, Entity monster) {
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

        while (player.getLifePoints() > 0 && monster.getLifePoints() > 0) {
            System.out.println("------------------");
            System.out.println("Player: " + player.getLifePoints() + " lifepoints");
            System.out.println("Monster: " + monster.getLifePoints() + " lifepoints");
            System.out.println("Attacks:");
            System.out.println("• 0: Fist - " + player.getDamages() + " damages.");
            for (int i = 0; i < player.getWeapons().size(); i++) {
                Weapon weapon = player.getWeapons().get(i);
                System.out.println("• " + i+1 + ": " + weapon.getName() + " - " + weapon.getDamage() + " damages.");
            }

            Scanner scan = new Scanner(System.in);
            System.out.print("Choose weapon:");

            try {
                int weaponIndex = Integer.parseInt(scan.nextLine());
                if (weaponIndex == 0) {
                    monster.removeLifePoints(player.getDamages());
                }
                else {
                    Weapon selectedWeapon = player.getWeapons().get(weaponIndex - 1);
                    monster.removeLifePoints(selectedWeapon.getDamage());
                }

                if (monster.getLifePoints() > 0) {
                    player.removeLifePoints(monster.getDamages());
                }
            } catch (Exception e) {
                System.out.println("Invalid weapon!");
            }
        }

        if (player.getLifePoints() > 0) {
            System.out.println("You won the fight!");
            return true;
        }
        else {
            System.out.println("You lost the fight...");
            return false;
        }
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
