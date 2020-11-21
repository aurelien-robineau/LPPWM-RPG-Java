package com.lpweb.rpg.entities;

public abstract class Entity {
    protected int lifePoints;
    protected int damages; 

    public Entity(int lifePoints, int damages) {
        this.lifePoints = lifePoints;
        this.damages = damages;
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    public void addLifePoints(int points) {
        this.lifePoints += points;
    }

    public void removeLifePoints(int points) {
        this.lifePoints -= points;
    }

    public int getDamages() {
        return this.damages;
    }

    public abstract String mapRepresentation();
}
