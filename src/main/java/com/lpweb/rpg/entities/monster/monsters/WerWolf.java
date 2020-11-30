package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class WerWolf extends Monster {
    private static final int LIFE_POINTS = 40;
    private static final int DAMAGES = 20;
    private static final int KILL_REWARD = 50;

    public WerWolf() {
        super(LIFE_POINTS, DAMAGES, KILL_REWARD);
    }

    @Override
    public String mapRepresentation() {
        return "Ww";
    }
}
