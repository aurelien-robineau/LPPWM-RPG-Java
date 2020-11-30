package com.lpweb.rpg.entities;

/**
 * Entities are placed into the map.
 */
public abstract class Entity {
    /**
     * Number of lifepoints of the entity.
     */
    protected int lifePoints;

    /**
     * Damages the entity inflics to another when attacking it.
     */
    protected int damages;

    /**
     * Reward (gold) given to the player when he kills the entity.
     */
    protected int killReward;

    public Entity(int lifePoints, int damages, int killReward) {
        this.lifePoints = lifePoints;
        this.damages = damages;
        this.killReward = killReward;
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    public int getDamages() {
        return this.damages;
    }

    public int getReward() {
        return this.killReward;
    };

    /**
     * Add lifepoints to the entity.
     * @param points - Number of lifepoints to add.
     * @return int - Number of lifepoints effectively added.
     */
    public int addLifePoints(int points) {
        this.lifePoints += points;
        return points;
    }

    /**
     * Remove lifePoints to the entity.
     * @param points - Number of lifepoints to remove.
     * @return int - Number of lifepoints effectively removed.
     */
    public int removeLifePoints(int points) {
        // Minimum number of lifepoints is 0
        points = this.lifePoints - points >= 0 ? points : this.lifePoints;

        this.lifePoints -= points;
        return points;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * Attack another entity.
     * @param entity - Entity to attack.
     */
    public void attack(Entity entity) {
        entity.removeLifePoints(this.getDamages());
    }

    /**
     * Entities with less than 0 lifepoints are considered invicible.
     * @return boolean - Is the entity invicible.
     */
    public boolean isInvincible() {
        return this.lifePoints < 0;
    };

    /**
     * How the entity should be represented on the map.
     * @return
     */
    public abstract String mapRepresentation();
}
