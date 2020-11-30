package com.lpweb.rpg.items.weapon.weapons;

import com.lpweb.rpg.items.weapon.Weapon;

public class Bow extends Weapon
{
    private static final int DAMAGE = 25;
    private static final int PRICE = 40;

    public Bow() {
        super(DAMAGE, PRICE);
    }

    public String ascii_art() {
        return
            "\\" + "\n" +
            "|\\" + "\n" +
            "| \\" + "\n" +
            "| |" + "\n" +
            "|---->" + "\n" +
            "| |" + "\n" +
            "| /" + "\n" +
            "|/" + "\n" +
            "/" + "\n";
    }
}