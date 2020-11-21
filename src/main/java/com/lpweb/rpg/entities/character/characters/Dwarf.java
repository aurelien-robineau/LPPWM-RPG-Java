package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.character.Character;

public class Dwarf extends Character {
    private static final int LIFE_POINTS = 20;
    private static final int DAMAGES = 5;

    public Dwarf() {
        super(LIFE_POINTS, DAMAGES);
    }

    @Override
    public String mapRepresentation() {
        return "Dw";
    }
}

