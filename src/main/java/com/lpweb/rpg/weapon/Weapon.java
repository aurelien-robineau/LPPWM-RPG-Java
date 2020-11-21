package com.lpweb.rpg.weapon;

import com.lpweb.rpg.entities.monster.Monster;
import com.lpweb.rpg.entities.obstacle.Obstacle;

public abstract class Weapon
{
    private int damage;
    private int price;

    public Weapon(int damage, int price) {
        this.damage = damage;
        this.price = price;
    }

    public int getDamage() { return this.damage; }

    public int getPrice() { return this.price; }

    public void attack(Monster monster) {
        monster.removeLifePoints(this.damage);
    }

    public void attack(Obstacle obstacle) {
        obstacle.removeLifePoints(this.damage);
    }

    public abstract String ascii_art();

    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "Arme de type " + this.getClass().getSimpleName() + " infligeant " + this.damage + " dégâts. Prix: " + this.price + " pièces d'or.\n" + this.ascii_art();
    }
}