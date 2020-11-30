package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.character.Character;
import com.lpweb.rpg.items.drink.Drink;
import com.lpweb.rpg.items.weapon.Weapon;

public class Wizard extends Character {
    private static final int LIFE_POINTS = 40;
    private static final int MAX_LIFE_POINTS = 40;
    private static final int DAMAGES = 4;
    private static final int DAMAGE_INCREASE_WITH_WOODSTICK = 90;
    private static final int REGENERATION_INCREASE_WITH_POTION = 50;

    /**
     * Wizard can increase their maximum lifepoints.
     */
    private int aditionalLifePoints = 0;

    public Wizard() {
        super(LIFE_POINTS, DAMAGES, MAX_LIFE_POINTS);
    }

    @Override
    public void attack(Entity entity, Weapon weapon) {
        entity.removeLifePoints(this.getDamageWith(weapon));
    }

    @Override
    public int drink(Drink drink) {
        // Potions increase wizard maximum lifepoints.
        if (drink.getName().equals("Potion")) {
            this.aditionalLifePoints = 15;
        }
        return this.addLifePoints(this.getRegenerationWith(drink));
    }

    @Override
    public int getMaxLifepoints() {
        return super.getMaxLifepoints() + this.aditionalLifePoints;
    }

    @Override
    public int getDamageWith(Weapon weapon) {
        // Wizards make more damages with woodstick.
        if (weapon.getName().equals("WoodStick")) {
            return weapon.getDamage() + DAMAGE_INCREASE_WITH_WOODSTICK;
        }

        return super.getDamageWith(weapon);
    }

    @Override
    public int getRegenerationWith(Drink drink) {
        // Wizards regenerate more with potions.
        if (drink.getName().equals("Potion")) {
            return drink.getRegeneration() + REGENERATION_INCREASE_WITH_POTION;
        }

        return super.getRegenerationWith(drink);
    }

    @Override
    public String mapRepresentation() {
        return "Wz";
    }

    public static void displayPresentation() {
        System.out.println("-- Wizard -- ");
        System.out.println("The Wizard is weak and can only have " + MAX_LIFE_POINTS + " lifepoints maximum.");
        System.out.println("Yet, when in possession of a magical woodstick, he can be the more dangerous character.");
        System.out.println("He loves to drink magic potions, and seems to be the only one.");
    }
}
