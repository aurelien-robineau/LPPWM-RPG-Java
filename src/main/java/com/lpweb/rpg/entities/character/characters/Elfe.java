package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.character.Character;

public class Elfe extends Character {
    private static final int LIFE_POINTS = 100;

    public Elfe() {
        super(LIFE_POINTS);
    }

    @Override
    public String mapRepresentation() {
        return "Ef";
    }
}
