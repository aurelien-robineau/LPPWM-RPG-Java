package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.character.Character;

public class Wizard extends Character {
    private static final int LIFE_POINTS = 10;
    private static final int DAMAGES = 2;

    public Wizard() {
        super(LIFE_POINTS, DAMAGES);
    }

    @Override
    public String mapRepresentation() {
        return "Wz";
    }
}
