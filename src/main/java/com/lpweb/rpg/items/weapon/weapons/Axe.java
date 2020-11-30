package com.lpweb.rpg.items.weapon.weapons;

import com.lpweb.rpg.items.weapon.Weapon;

public class Axe extends Weapon
{
    private static final int DAMAGE = 30;
    private static final int PRICE = 40;

    public Axe() {
        super(DAMAGE, PRICE);
    }

    public String ascii_art() {
        return
            "  '  /\\  ' " + "\n" +
            " //.-||-.\\\\"  + "\n" +
            "(| -=||=- |)" + "\n" +
            " \\\\.-||-.//"  + "\n" +
            "  '  ||  '" + "\n" +
            "     ||" + "\n" +
            "     ||" + "\n" +           
            "     ()" + "\n";
    }
}