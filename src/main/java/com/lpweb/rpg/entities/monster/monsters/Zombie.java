package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Zombie extends Monster {
    private static final int LIFE_POINTS = 20;

    public Zombie() {
        super(LIFE_POINTS);
    }

    @Override
    public char mapRepresentation() {
        return 'Z';
    }
}
