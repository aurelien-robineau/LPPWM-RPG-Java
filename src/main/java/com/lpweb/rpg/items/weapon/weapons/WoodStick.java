package com.lpweb.rpg.items.weapon.weapons;

import com.lpweb.rpg.items.weapon.Weapon;

public class WoodStick extends Weapon
{
    private static final int DAMAGE = 7;
    private static final int PRICE = 60;

    public WoodStick() {
        super(DAMAGE, PRICE);
    }

    public String ascii_art() {
        return
            "--------------------------------------------/**\\" + "\n" +
            "--------------------------------------------\\**/" + "\n";
    }
}