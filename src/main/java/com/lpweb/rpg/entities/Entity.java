package com.lpweb.rpg.entities;

public abstract class Entity {
    private int lifePoints;

    public Entity(int lifePoints) {
        this.lifePoints = lifePoints;
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

    public abstract String mapRepresentation();
}
