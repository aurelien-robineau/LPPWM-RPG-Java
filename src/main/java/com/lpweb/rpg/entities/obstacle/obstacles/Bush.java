package com.lpweb.rpg.entities.obstacle.obstacles;

import com.lpweb.rpg.entities.obstacle.Obstacle;

public class Bush extends Obstacle {
    private static final int LIFE_POINTS = 5;
    private static final int DAMAGES = 1;
    private static final int KILL_REWARD = 0;

    public Bush() {
        super(LIFE_POINTS, DAMAGES, KILL_REWARD);
    }

    @Override
    public String mapRepresentation() {
        return "**";
    }
}
