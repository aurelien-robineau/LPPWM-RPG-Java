package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class WerWolf extends Monster {
    private static final int LIFE_POINTS = 50;

    public WerWolf() {
        super(LIFE_POINTS);
    }

    @Override
    public String mapRepresentation() {
        return "Ww";
    }
}
