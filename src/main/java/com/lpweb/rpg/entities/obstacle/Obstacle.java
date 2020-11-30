package com.lpweb.rpg.entities.obstacle;

import com.lpweb.rpg.entities.Entity;

public abstract class Obstacle extends Entity {
    public Obstacle(int lifePoints, int damages, int killReward) {
        super(lifePoints, damages, killReward);
    }
}
