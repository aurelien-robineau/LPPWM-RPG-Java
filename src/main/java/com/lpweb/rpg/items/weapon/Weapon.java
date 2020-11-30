package com.lpweb.rpg.items.weapon;

import com.lpweb.rpg.ConsoleRPG;
import com.lpweb.rpg.items.Item;

/**
 * Weapon bought by the player to fight entities.
 */
public abstract class Weapon extends Item
{
    /**
     * Damages the weapon inflics to the entity.
     */
    private int damage;

    public Weapon(int damage, int price) {
        super(price);
        this.damage = damage;
    }

    public int getDamage() { 
        return this.damage;
    }
    
    public abstract String ascii_art();

    @Override
    public String toString() {
        return this.getName() + ": " + ConsoleRPG.getPlayer().getDamageWith(this) + " damages. PRICE: " + this.price + " gold\n" + this.ascii_art();
    }
}