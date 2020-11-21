package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class WerWolf extends Monster {
    private static final int LIFE_POINTS = 40;
    private static final int DAMAGES = 20;

    public WerWolf() {
        super(LIFE_POINTS, DAMAGES);
    }

    @Override
    public String mapRepresentation() {
        return "Ww";
    }
}
