package com.lpweb.rpg.items.drink.drinks;

import com.lpweb.rpg.items.drink.Drink;

public class Potion extends Drink {
    public static final int REGENERATION = 5;
    public static final int PRICE = 20;
    
    public Potion() {
        super(REGENERATION, PRICE);
    }
}
