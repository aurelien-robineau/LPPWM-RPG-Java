package com.lpweb.rpg.map;

import java.util.ArrayList;
import java.util.HashMap;

import com.lpweb.rpg.entities.Entity;

public class Map {
    public enum DIRECTION {
        TOP, RIGHT, BOTTOM, LEFT
    }

    private Entity player;

    private HashMap<String, Integer> playerPosition = new HashMap<String, Integer>();

    private ArrayList<ArrayList<Entity>> cells = new ArrayList<>();

    public Map(int size, Entity player) {
        this.player = player;

        // Set initial player position (bottom left)
        this.playerPosition.put("x", 0);
        this.playerPosition.put("y", size - 1);

        // Init map
        this.initMap(size);
        this.fillMap();
    }

    public void render() {
        // Map border top
        System.out.print("|");
        for (int i = 0; i < this.cells.get(0).size(); i++) {
            System.out.print("--");
        }
        System.out.println("|");

        for (ArrayList<Entity> row : this.cells) {
            // Map border left
            System.out.print("|");
            // Map cells
            for (Entity entity : row) {
                if (entity != null) {
                    System.out.print(entity.mapRepresentation() + " ");
                }
                else {
                    System.out.print("  ");
                }
            }
            // Map border right
            System.out.println("|");
        }
        
        // Map border bottom
        System.out.print("|");
        for (int i = 0; i < this.cells.get(0).size(); i++) {
            System.out.print("--");
        }
        System.out.println("|");
    }

    public void movePlayerTo(DIRECTION direction) {
        int xMove;
        int yMove;

        switch (direction) {
            case TOP:
                xMove = 0;
                yMove = -1;
                break;
            case RIGHT:
                xMove = 1;
                yMove = 0;
                break;
            case BOTTOM:
                xMove = 0;
                yMove = 1;
                break;
            case LEFT:
                xMove = -1;
                yMove = 0;
                break;
            default:
                xMove = 0;
                yMove = 0;
        }

        try {
            // Add player to new position
            this.cells
            .get(this.playerPosition.get("y") + yMove)
            .set(this.playerPosition.get("x") + xMove, this.player);

            // Remove player from current position
            this.cells
            .get(this.playerPosition.get("y"))
            .set(this.playerPosition.get("x"), null);

            // Update player position
            this.playerPosition.put("x", this.playerPosition.get("x") + xMove);
            this.playerPosition.put("y", this.playerPosition.get("y") + yMove);
        }
        catch (IndexOutOfBoundsException e) {
            // If trying to move player outside of the map, do nothing
            return;
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
        this.cells
            .get(this.playerPosition.get("y"))
            .set(this.playerPosition.get("x"), this.player);
    }

    public void performAction(String action) throws Exception {
        switch (action) {
            case "z":
                this.movePlayerTo(DIRECTION.TOP);
                break;
            case "s":
                this.movePlayerTo(DIRECTION.BOTTOM);
                break;
            case "q":
                this.movePlayerTo(DIRECTION.LEFT);
                break;
            case "d":
                this.movePlayerTo(DIRECTION.RIGHT);
                break;
            default:
                throw new Exception(action + " is not a valid action.");
        }

        this.render();
    }
}
