package com.lpweb.rpg.items.drink.drinks;

import com.lpweb.rpg.items.drink.Drink;

public class Water extends Drink {
    public static final int REGENERATION = 5;
    public static final int PRICE = 5;
    
    public Water() {
        super(REGENERATION, PRICE);
    }
}