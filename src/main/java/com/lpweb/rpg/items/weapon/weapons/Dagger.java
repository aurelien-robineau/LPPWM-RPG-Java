package com.lpweb.rpg.items.weapon.weapons;

import com.lpweb.rpg.items.weapon.Weapon;

public class Dagger extends Weapon
{
    private static final int DAMAGE = 15;
    private static final int PRICE = 20;

    public Dagger() {
        super(DAMAGE, PRICE);
    }

    public String ascii_art() {
        return
            "      /| ________________" + "\n" +
            "O|===|* >________________>" + "\n" +
            "      \\|" + "\n";
    }
}