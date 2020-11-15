package com.lpweb.rpg.weapon.weapons;

import com.lpweb.rpg.weapon.Weapon;

public class Axe extends Weapon
{
    private static final int DAMAGE = 15;
    private static final int PRICE = 30;

    public Axe() {
        super(DAMAGE, PRICE);
    }

    public String ascii_art() {
        return
        "/>         _________________________________\n" +
        "[########[]_________________________________>\n" +
        "\\>\n";
    }
}