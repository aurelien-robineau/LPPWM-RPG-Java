package com.lpweb.rpg.weapon.weapons;

import com.lpweb.rpg.weapon.Weapon;

public class Knife extends Weapon
{
    private static final int DAMAGE = 12;
    private static final int PRICE = 24;

    public Knife() {
        super(DAMAGE, PRICE);
    }

    public String ascii_art() {
        return
        "/>         _________________________________\n" +
        "[########[]_________________________________>\n" +
        "\\>\n";
    }
}