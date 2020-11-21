package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.character.Character;

public class Dwarf extends Character {
    private static final int LIFE_POINTS = 100;

    public Dwarf() {
        super(LIFE_POINTS);
    }

    @Override
    public String mapRepresentation() {
        return "Dw";
    }
}

