package com.lpweb.rpg;

import java.util.ArrayList;
import java.util.HashMap;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.monster.monsters.*;
import com.lpweb.rpg.entities.obstacle.obstacles.*;

public class Map {
    /**
     * Possible player directions when moving.
     */
    public enum DIRECTION {
        TOP, RIGHT, BOTTOM, LEFT
    }

    /**
     * Current player position on the map.
     */
    private HashMap<String, Integer> playerPosition = new HashMap<String, Integer>();

    /**
     * Cells of the map, containing an entity or nothing.
     */
    private ArrayList<ArrayList<Entity>> cells = new ArrayList<>();

    public Map(int size) {
        // Set initial player position (bottom left)
        this.playerPosition.put("x", 0);
        this.playerPosition.put("y", size - 1);

        // Init map
        this.initMap(size);
    }

    /**
     * Display map in console.
     */
    public void render() {
        // Display map border top
        System.out.print("|");
        for (int i = 0; i < this.cells.get(0).size(); i++) {
            // Exit on the top right border
            if (i == this.cells.get(0).size() - 2) {
                System.out.print("-|");
            }
            // Idem
            else if (i == this.cells.get(0).size() - 1) {
                System.out.print("  ");
            }
            else {
                System.out.print("--");
            }
        }
        System.out.println("|");

        // Display map content
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
        
        // Display map border bottom
        System.out.print("|");
        for (int i = 0; i < this.cells.get(0).size(); i++) {
            System.out.print("--");
        }
        System.out.println("|");
    }

    /**
     * Move the player in a direction.
     * @param direction - Direction of the move.
     */
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
            // Cell player is trying to move on
            Entity newCellEntity = this.cells
                .get(this.playerPosition.get("y") + yMove)
                .get(this.playerPosition.get("x") + xMove);

            // Make player encounter the cell
            Encounter encounter = new Encounter(newCellEntity);
            boolean canMove = encounter.enter();

            if (canMove) {
                // Add player to new position
                this.cells
                .get(this.playerPosition.get("y") + yMove)
                .set(this.playerPosition.get("x") + xMove, ConsoleRPG.getPlayer());

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

    /**
     * Initialize the map by filling it with entities.
     * @param size - Size in cells of the map (map is a square).
     */
    private void initMap(int size) {
        // Rows
        for (int y = 0; y < size; y++) {
            ArrayList<Entity> row = new ArrayList<>();
            // Columns
            for (int x = 0; x < size; x++) {
                int random = (int) (Math.random() * 2000);
                // Cell has 1/100 chances to be a WerWolf
                if (random <= 20) {
                    row.add(new WerWolf());
                }
                // Cell has 3/100 chances to be a Zombie
                else if (20 < random && random <= 80) {
                    row.add(new Zombie());
                }
                // Cell has 5/100 chances to be a Gnome
                else if (80 < random && random <= 180) {
                    row.add(new Gnome());
                }
                // Cell has 3/100 chances to be a Wall
                else if (180 < random && random <= 240) {
                    row.add(new Wall());
                }
                // Cell has 5/100 chances to be a Bush
                else if (240 < random && random <= 340) {
                    row.add(new Bush());
                }
                // Cell has 2/100 chances to be a Fire
                else if (340 < random && random <= 380) {
                    row.add(new Fire());
                }
                // Cell has 5/100 chances to be a Rock
                else if (380 < random && random <= 480) {
                    row.add(new Rock());
                }
                // Cell has 76/100 chances to be empty
                else {
                    row.add(null);
                }
            }

            this.cells.add(row);
        }

        // Add the unique dragon to the top right corner (keeping the exit)
        this.cells
        .get(0)
        .set(this.cells.size() - 1, new Dragon());

        // Add player
        this.cells
        .get(this.playerPosition.get("y"))
        .set(this.playerPosition.get("x"), ConsoleRPG.getPlayer());
    }

    /**
     * Perform an action on the map.
     * @return boolean - Did the action succeed.
     */
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

    public HashMap<String, Integer> getPlayerPosition() {
        return this.playerPosition;
    }

    public int size() {
        return this.cells.size();
    }
}
