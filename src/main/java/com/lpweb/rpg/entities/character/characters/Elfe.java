package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.character.Character;
import com.lpweb.rpg.items.drink.Drink;
import com.lpweb.rpg.items.weapon.Weapon;

public class Elfe extends Character {
    private static final int LIFE_POINTS = 30;
    private static final int MAX_LIFE_POINTS = 50;
    private static final int DAMAGES = 4;
    private static final int DAMAGE_INCREASE_WITH_BOW = 25;
    private static final int REGENERATION_INCREASE_WITH_ELIXIR = 30;

    public Elfe() {
        super(LIFE_POINTS, DAMAGES, MAX_LIFE_POINTS);
    }

    /**
     * Does the Elfe has a bow in his inventory.
     * @return boolean
     */
    private boolean haveBow() {
        for (Weapon weapon: this.getWeapons()) {
            if (weapon.getName().equals("Bow")) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int removeLifePoints(int points) {
        // Elfes take less damages when they have a bow
        return super.removeLifePoints((int) (this.haveBow() ? points / 1.5 : points));
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
        // Elfes make more damages with a bow.
        if (weapon.getName().equals("Bow")) {
            return weapon.getDamage() + DAMAGE_INCREASE_WITH_BOW;
        }

        return super.getDamageWith(weapon);
    }

    @Override
    public int getRegenerationWith(Drink drink) {
        // Elfes regenerate more with Elixir
        if (drink.getName().equals("Elixir")) {
            return drink.getRegeneration() + REGENERATION_INCREASE_WITH_ELIXIR;
        }

        return super.getRegenerationWith(drink);
    }

    @Override
    public String mapRepresentation() {
        return "Ef";
    }

    public static void displayPresentation() {
        System.out.println("-- Elfe -- ");
        System.out.println("The Elfe can have " + MAX_LIFE_POINTS + " lifepoints maximum.");
        System.out.println("He is confortable with a bow, wich allow him to fight from distance and to take less damages.");
        System.out.println("He loves to drink elixir, wich is really efficient on him.");
    }
}
