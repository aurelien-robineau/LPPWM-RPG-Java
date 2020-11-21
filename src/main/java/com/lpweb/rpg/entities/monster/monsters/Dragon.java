package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Dragon extends Monster {
    private static final int LIFE_POINTS = 100;

    public Dragon() {
        super(LIFE_POINTS);
    }

    @Override
    public String mapRepresentation() {
        return "Dg";
    }
}
