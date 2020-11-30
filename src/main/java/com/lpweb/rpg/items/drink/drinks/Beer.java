package com.lpweb.rpg.items.drink.drinks;

import com.lpweb.rpg.items.drink.Drink;

public class Beer extends Drink {
    public static final int REGENERATION = 20;
    public static final int PRICE = 20;
    
    public Beer() {
        super(REGENERATION, PRICE);
    }
}