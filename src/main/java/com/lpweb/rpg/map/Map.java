package com.lpweb.rpg.map;

import java.util.ArrayList;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.character.characters.Dwarf;

public class Map {
    public enum DIRECTION {
        TOP, RIGHT, BOTTOM, LEFT
    }

    private ArrayList<ArrayList<Entity>> cells = new ArrayList<>();

    public Map(int size) {
        this.initMap(size);
        this.fillMap();
    }

    public void show() {
        for (ArrayList<Entity> row : this.cells) {
            for (Entity entity : row) {
                if (entity != null) {
                    System.out.print(entity.mapRepresentation());
                }
                else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    private void initMap(int size) {
        for (int y = 0; y < size; y++) {
            ArrayList<Entity> row = new ArrayList<>();
            for (int x = 0; x < size; x++) {
                row.add(null);
            }

            this.cells.add(row);
        }
    }

    private void fillMap() {
        this.cells.get(15).set(15, new Dwarf());
    }
}
