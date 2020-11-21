package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Gnome extends Monster {
    private static final int LIFE_POINTS = 10;
    private static final int DAMAGES = 4;

    public Gnome() {
        super(LIFE_POINTS, DAMAGES);
    }

    @Override
    public String mapRepresentation() {
        return "Gn";
    }
}
