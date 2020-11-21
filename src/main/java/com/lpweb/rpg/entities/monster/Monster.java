package com.lpweb.rpg.entities.monster;

import com.lpweb.rpg.entities.Entity;

public abstract class Monster extends Entity {
    public Monster(int lifePoints, int damages) {
        super(lifePoints, damages);
    }
}
