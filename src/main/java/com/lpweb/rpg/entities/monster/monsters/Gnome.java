package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Gnome extends Monster {
    private static final int LIFE_POINTS = 10;

    public Gnome() {
        super(LIFE_POINTS);
    }

    @Override
    public String mapRepresentation() {
        return "Gn";
    }
}
