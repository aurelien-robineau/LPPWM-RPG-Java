package com.lpweb.rpg.entities.character.characters;

import com.lpweb.rpg.entities.character.Character;

public class Wizard extends Character {
    private static final int LIFE_POINTS = 100;

    public Wizard() {
        super(LIFE_POINTS);
    }

    @Override
    public char mapRepresentation() {
        return 'W';
    }
}
