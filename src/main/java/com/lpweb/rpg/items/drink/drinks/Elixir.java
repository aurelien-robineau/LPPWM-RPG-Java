package com.lpweb.rpg.items.drink.drinks;

import com.lpweb.rpg.items.drink.Drink;

public class Elixir extends Drink {
    public static final int REGENERATION = 30;
    public static final int PRICE = 25;
    
    public Elixir() {
        super(REGENERATION, PRICE);
    }
}