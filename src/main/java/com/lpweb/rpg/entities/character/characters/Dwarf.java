package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.character.Character;
import com.lpweb.rpg.items.drink.Drink;
import com.lpweb.rpg.items.weapon.Weapon;

public class Dwarf extends Character {
    private static final int LIFE_POINTS = 20;
    private static final int MAX_LIFE_POINTS = 100;
    private static final int DAMAGES = 5;
    private static final int DAMAGE_INCREASE_WITH_AXE = 30;
    private static final int REGENERATION_INCREASE_WITH_BEER = 20;

    public Dwarf() {
        super(LIFE_POINTS, DAMAGES, MAX_LIFE_POINTS);
    }

    @Override
    public void attack(Entity entity, Weapon weapon) {
        entity.removeLifePoints(this.getDamageWith(weapon));
    }

    @Override
    public int drink(Drink drink) {
        return this.addLifePoints(this.getRegenerationWith(drink));
    }

    @Override
    public int getDamageWith(Weapon weapon) {
        // Drawfs make more damages with axes.
        if (weapon.getName().equals("Axe")) {
            return weapon.getDamage() + DAMAGE_INCREASE_WITH_AXE;
        }

        return super.getDamageWith(weapon);
    }

    @Override
    public int getRegenerationWith(Drink drink) {
        if (drink.getName().equals("Beer")) {
            // Dwarfs regenerate more with beers.
            return drink.getRegeneration() + REGENERATION_INCREASE_WITH_BEER;
        }

        return super.getRegenerationWith(drink);
    }

    @Override
    public String mapRepresentation() {
        return "Dw";
    }

    public static void displayPresentation() {
        System.out.println("-- Dwarf -- ");
        System.out.println("The Dwarf is strong and can have " + MAX_LIFE_POINTS + " lifepoints maximum.");
        System.out.println("He loves axes and can be very powerful with it.");
        System.out.println("He also loves beer to cheer up in dark moments.");
    }
}

