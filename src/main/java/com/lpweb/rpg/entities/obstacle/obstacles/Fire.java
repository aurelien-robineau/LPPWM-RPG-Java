package com.lpweb.rpg.entities.obstacle.obstacles;

import com.lpweb.rpg.entities.obstacle.Obstacle;

public class Fire extends Obstacle {
    private static final int LIFE_POINTS = 10;
    private static final int DAMAGES = 15;
    private static final int KILL_REWARD = 0;

    public Fire() {
        super(LIFE_POINTS, DAMAGES, KILL_REWARD);
    }

    @Override
    public String mapRepresentation() {
        return "^^";
    }
}
