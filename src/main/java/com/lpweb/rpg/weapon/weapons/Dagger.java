package com.lpweb.rpg.weapon.weapons;

import com.lpweb.rpg.weapon.Weapon;

public class Dagger extends Weapon
{
    private static final int DAMAGE = 7;
    private static final int PRICE = 14;

    public Dagger() {
        super(DAMAGE, PRICE);
    }

    public String ascii_art() {
        return
        "/>         _________________________________\n" +
        "[########[]_________________________________>\n" +
        "\\>\n";
    }
}