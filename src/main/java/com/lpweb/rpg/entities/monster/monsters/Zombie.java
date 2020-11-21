package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Zombie extends Monster {
    private static final int LIFE_POINTS = 20;
    private static final int DAMAGES = 5;

    public Zombie() {
        super(LIFE_POINTS, DAMAGES);
    }

    @Override
    public String mapRepresentation() {
        return "Zb";
    }
}
