package com.lpweb.rpg;

import java.util.Scanner;

import com.lpweb.rpg.entities.Entity;
import com.lpweb.rpg.entities.character.characters.Dwarf;
import com.lpweb.rpg.map.Map;

public class App 
{
    public static void main( String[] args )
    {
        Entity player = new Dwarf();
        Map map = new Map(30, player);
        map.render();

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Action (z: haut, s: bas, d: droite, q: gauche): ");
            String action = scan.nextLine();
            scan.close();

            try {
                map.performAction(action);
            }
            catch (Exception e) {
                System.out.println("Action invalide !");
            }
        }
    }
}
