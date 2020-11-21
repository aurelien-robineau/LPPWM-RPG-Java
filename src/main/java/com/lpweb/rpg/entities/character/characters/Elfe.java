package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.character.Character;

public class Elfe extends Character {
    private static final int LIFE_POINTS = 15;
    private static final int DAMAGES = 4;

    public Elfe() {
        super(LIFE_POINTS, DAMAGES);
    }

    @Override
    public String mapRepresentation() {
        return "Ef";
    }
}
