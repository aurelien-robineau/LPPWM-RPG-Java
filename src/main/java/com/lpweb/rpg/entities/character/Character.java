package com.lpweb.rpg.entities.character;

import java.util.ArrayList;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.weapon.Weapon;

public abstract class Character extends Entity {
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public Character(int lifePoints, int damages) {
        super(lifePoints, damages);
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }
}
