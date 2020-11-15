package com.lpweb.rpg.entities.obstacle.obstacles;

import com.lpweb.rpg.entities.obstacle.Obstacle;

public class Wall extends Obstacle {
    private static final int LIFE_POINTS = 100;

    public Wall() {
        super(LIFE_POINTS);
    }

    @Override
    public char mapRepresentation() {
        return '⃢';
    }
}
