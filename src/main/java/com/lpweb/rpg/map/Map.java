package com.lpweb.rpg.map;

import java.util.ArrayList;
import java.util.HashMap;

import com.lpweb.rpg.Encounter;
import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.monster.monsters.Dragon;
import com.lpweb.rpg.entities.monster.monsters.Gnome;
import com.lpweb.rpg.entities.monster.monsters.WerWolf;
import com.lpweb.rpg.entities.monster.monsters.Zombie;

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
    }

    public void render() {
        // Map border top
        System.out.print("|");
        for (int i = 0; i < this.cells.get(0).size(); i++) {
            if (i == this.cells.get(0).size() - 2) {
                System.out.print("-|");
            }
            else if (i == this.cells.get(0).size() - 1) {
                System.out.print("  ");
            }
            else {
                System.out.print("--");
            }
        }
        System.out.println("|");

        for (ArrayList<Entity> row : this.cells) {
            // Map border left
            System.out.print("|");
            // Map cells
            for (Entity entity : row) {
                if (entity != null) {
                    System.out.print(entity.mapRepresentation());
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
            Entity newCellEntity = this.cells
                .get(this.playerPosition.get("y") + yMove)
                .get(this.playerPosition.get("x") + xMove);

            Encounter encounter = new Encounter(player, newCellEntity);
            boolean canMove = encounter.enter();

            if (canMove) {
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
                int random = (int) (Math.random() * 1000);
                if (random <= 15) {
                    row.add(new WerWolf());
                }
                else if (15 < random && random <= 40) {
                    row.add(new Zombie());
                }
                else if (40 < random && random <= 100) {
                    row.add(new Gnome());
                }
                else {
                    row.add(null);
                }
            }

            this.cells.add(row);
        }

        // Add dragon to the top right corner
        this.cells
        .get(0)
        .set(this.cells.size() - 1, new Dragon());

        // Add player
        this.cells
        .get(this.playerPosition.get("y"))
        .set(this.playerPosition.get("x"), this.player);
    }

    public boolean playerWins() {
        return
            this.playerPosition.get("y") == 0 &&
            this.playerPosition.get("x") == this.cells.size() - 1;
    }

    public boolean performAction(String action) {
        switch (action) {
            case "z":
                this.movePlayerTo(DIRECTION.TOP);
                return true;
            case "s":
                this.movePlayerTo(DIRECTION.BOTTOM);
                return true;
            case "q":
                this.movePlayerTo(DIRECTION.LEFT);
                return true;
            case "d":
                this.movePlayerTo(DIRECTION.RIGHT);
                return true;
            default:
                return false;
        }
    }
}
