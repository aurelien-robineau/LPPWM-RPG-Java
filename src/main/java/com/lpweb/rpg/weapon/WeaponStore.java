package com.lpweb.rpg.weapon;

import java.util.ArrayList;

public class WeaponStore
{
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public WeaponStore() {}

    public WeaponStore(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void removeWeapon(Weapon weapon) {
        this.weapons.remove(weapon);
    }

    @Override
    public String toString() {
        String string = "Magasin d'armes. Inventaire :\n";
        for (Weapon weapon : this.weapons) {
            string += weapon + "\n";
        }

        return string;
    }
}