package com.lpweb.rpg.items.drink;

import com.lpweb.rpg.ConsoleRPG;
import com.lpweb.rpg.items.Item;

/**
 * Drinks are items that heal the player by adding lifepoints.
 */
public abstract class Drink extends Item {
    /**
     * Number of lifepoints to give to the player.
     */
    protected int regeneration;

    public Drink(int regeneration, int price) {
        super(price);
        this.regeneration = regeneration;
    }

    public int getRegeneration() {
        return this.regeneration;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + ConsoleRPG.getPlayer().getRegenerationWith(this) + " lifepoints regeneration. PRICE: " + this.price + " gold\n";
    }
}
