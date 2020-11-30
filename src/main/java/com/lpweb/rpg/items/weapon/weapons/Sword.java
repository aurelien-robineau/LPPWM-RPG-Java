package com.lpweb.rpg.items.weapon.weapons;

import com.lpweb.rpg.items.weapon.Weapon;

public class Sword extends Weapon
{
    private static final int DAMAGE = 20;
    private static final int PRICE = 30;

    public Sword() {
        super(DAMAGE, PRICE);
    }

    public String ascii_art() {
        return
            "         />_________________________________" + "\n" +
            "[########[]_________________________________>" + "\n" +
            "         \\>" + "\n";
    }
}