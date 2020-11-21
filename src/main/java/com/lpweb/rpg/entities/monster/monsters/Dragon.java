package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Dragon extends Monster {
    private static final int LIFE_POINTS = 100;
    private static final int DAMAGES = 50;

    public Dragon() {
        super(LIFE_POINTS, DAMAGES);
    }

    @Override
    public String mapRepresentation() {
        return "Dg";
    }
}
