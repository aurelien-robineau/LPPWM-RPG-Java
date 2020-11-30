package com.lpweb.rpg.entities.character;

import java.util.ArrayList;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.items.drink.Drink;
import com.lpweb.rpg.items.weapon.Weapon;

/**
 * A character is a entoty that can be played by the player.
 */
public abstract class Character extends Entity {
    private static final int KILL_REWARD = 100;

    /**
     * Maximum lifepoints the character can have.
     */
    private int maxLifepoints;

    /**
     * Gold of the character.
     */
    private int gold;

    /**
     * Weapons of the character.
     */
    private ArrayList<Weapon> weapons = new ArrayList<>();

    protected Character(int lifePoints, int damages, int maxLifepoints) {
        super(lifePoints, damages, KILL_REWARD);
        this.gold = 0;
        this.maxLifepoints = maxLifepoints;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public int getGold() {
        return this.gold;
    }

    public int getMaxLifepoints() {
        return maxLifepoints;
    }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public void removeGold(int amount) {
        this.gold -= amount;
    }

    public int getDamageWith(Weapon weapon) {
        return weapon.getDamage();
    }

    public int getRegenerationWith(Drink drink) {
        return drink.getRegeneration();
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void attack(Entity entity, Weapon weapon) {
        entity.removeLifePoints(weapon.getDamage());
    }

    public int drink(Drink drink) {
        return this.addLifePoints(drink.getRegeneration());
    }

    @Override
    public int addLifePoints(int points) {
        // Can not go over the maximum lifepoints
        int maxPoints = this.getMaxLifepoints() - this.getLifePoints();
        points = points < maxPoints ? points : maxPoints;

        super.addLifePoints(points);
        return points;
    }
}
