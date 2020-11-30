package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Zombie extends Monster {
    private static final int LIFE_POINTS = 20;
    private static final int DAMAGES = 5;
    private static final int KILL_REWARD = 15;

    public Zombie() {
        super(LIFE_POINTS, DAMAGES, KILL_REWARD);
    }

    @Override
    public String mapRepresentation() {
        return "Zb";
    }
}
