package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Dragon extends Monster {
    private static final int LIFE_POINTS = 100;
    private static final int DAMAGES = 50;
    private static final int KILL_REWARD = 1000;

    public Dragon() {
        super(LIFE_POINTS, DAMAGES, KILL_REWARD);
    }

    @Override
    public String mapRepresentation() {
        return "Dg";
    }
}
