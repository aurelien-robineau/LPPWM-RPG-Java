package com.lpweb.rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.lpweb.rpg.items.drink.Drink;
import com.lpweb.rpg.items.drink.drinks.*;
import com.lpweb.rpg.items.weapon.Weapon;
import com.lpweb.rpg.items.weapon.weapons.*;

/**
 * The store allow the player to buy items.
 * The store is unique and can be open from anywhere in the map.
 */
public class Store
{
    /**
     * Instance of the store (singleton)
     */
    private static final Store instance = new Store();

    /**
     * List of drinks for sale in the store.
     */
    private ArrayList<Drink> drinks = new ArrayList<>(Arrays.asList(
        new Beer(),
        new Soup(),
        new Elixir(),
        new Potion(),
        new Water()
    ));

    /**
     * List of weapons for sale in the store.
     */
    private ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
        new Axe(),
        new Bow(),
        new Dagger(),
        new Knife(),
        new Sword(),
        new WoodStick()
    ));

    public static Store getInstance() {
        return instance;
    }

    private Store() {
        // Sort items by price
        Collections.sort(this.weapons);
        Collections.sort(this.drinks);
    };

    /**
     * Enter the store.
     * Display a message, list the items for sale and ask the player what he
     * wants to buy.
     */
    public void enter() {
        // Entering store welcome message and list items for sale
        System.out.println(this);

        while (true) {
            System.out.println("Gold: " + ConsoleRPG.getPlayer().getGold());
            System.out.print("What do you want to buy (press 'enter' to leave)? ");

            String action = ConsoleRPG.getScanner().nextLine();
    
            // Leave the shop on empty 'enter'
            if (action.equals("")) {
                System.out.println("You left the shop.");
                break;
            }
            else {
                try {
                    // Only indexes are valid, so action must be a integer
                    int actionIndex = Integer.parseInt(action);
                    
                    // First indexes are for drinks
                    if (actionIndex < this.drinks.size()) {
                        this.buyDrink(actionIndex);
                    }
                    // Then comes the weapons
                    else {
                        this.buyWeapon(actionIndex - this.drinks.size());
                    }
                }
                catch (NumberFormatException e) {
                    System.err.println("Invalid action.");
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Make the player buy a drink.
     * Drinks are consomables and are used instantly.
     * @param drinkIndex - Index in the shop drinks list of the drink to buy.
     * @throws Exception - Error when buying the drink
     */
    public void buyDrink(int drinkIndex) throws Exception {
        try {
            Drink drink = this.drinks.get(drinkIndex);

            if (ConsoleRPG.getPlayer().getGold() >= drink.getPrice()) {
                ConsoleRPG.getPlayer().removeGold(drink.getPrice());
                // Instantly use the drink
                int recoveredLifepoints = ConsoleRPG.getPlayer().drink(drink);
                System.out.println("You recovered " + recoveredLifepoints + " lifepoints!");
            }
            else {
                // Not enought gold to buy the item
                throw new Exception("Not enought gold.");
            }
        }
        // Invalid index
        catch (IndexOutOfBoundsException e) {
            throw new Exception("Invalid action.");
        }
    }

    /**
     * Make the player buy a weapon.
     * Weapons are stored in the user inventory.
     * @param weaponIndex - Index in the shop weapons list of the weapon to buy.
     * @throws Exception - Error when buying the weapon
     */
    public void buyWeapon(int weaponIndex) throws Exception {
        try {
            Weapon weapon = this.weapons.get(weaponIndex);

            if (ConsoleRPG.getPlayer().getGold() >= weapon.getPrice()) {
                ConsoleRPG.getPlayer().removeGold(weapon.getPrice());
                // Store weapon in inventory
                ConsoleRPG.getPlayer().addWeapon(weapon);
                System.out.println("Weapon bought!");
            }
            else {
                // Not enought gold to buy the item
                throw new Exception("Not enought gold.");
            }
        }
        // Invalid index
        catch (IndexOutOfBoundsException e) {
            throw new Exception("Invalid action.");
        }
    }

    @Override
    public String toString() {
        String string = "Welcome to the shop. Items for sale:\n";
        int i = 0;

        string += "----- Drinks -----\n";
        while (i < this.drinks.size()) {
            string += "• " + i + ": " + this.drinks.get(i) + "\n";
            i++;
        }

        string += "----- Weapons -----\n";
        while(i < this.weapons.size() + this.drinks.size()) {
            string += "• " + i + ": " + this.weapons.get(i - this.drinks.size()) + "\n";
            i++;
        }

        return string;
    }
}