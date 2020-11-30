package com.lpweb.rpg.items.drink.drinks;

import com.lpweb.rpg.items.drink.Drink;

public class Soup extends Drink {
    public static final int REGENERATION = 15;
    public static final int PRICE = 10;
    
    public Soup() {
        super(REGENERATION, PRICE);
    }
}