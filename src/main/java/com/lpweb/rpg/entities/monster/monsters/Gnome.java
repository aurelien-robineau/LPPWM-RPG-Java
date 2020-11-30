package com.lpweb.rpg.entities.monster.monsters;

import com.lpweb.rpg.entities.monster.Monster;

public class Gnome extends Monster {
    private static final int LIFE_POINTS = 10;
    private static final int DAMAGES = 4;
    private static final int KILL_REWARD = 5;

    public Gnome() {
        super(LIFE_POINTS, DAMAGES, KILL_REWARD);
    }

    @Override
    public String mapRepresentation() {
        return "Gn";
    }
}
