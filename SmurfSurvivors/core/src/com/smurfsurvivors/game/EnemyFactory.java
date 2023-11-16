package com.smurfsurvivors.game;

import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class EnemyFactory {
    Random rnd = new Random();
    public EnemyFactory(){

    }

    public ArrayList<Enemy> makeDemons(int numDemons, int playerX, int playerY){
        ArrayList<Enemy> demons = new ArrayList<Enemy>();
        int spawnDistance = 1500;
        int spawnRange = 2000;

        for (int i = 0; i < 1; i++){
            int[] spawns = chooseRandomSpawn(playerX, playerY, spawnDistance, spawnRange);
            int spawnX = spawns[0];
            int spawnY = spawns[1];
            demons.add(new Demon(spawnX, spawnY));
        }
        return demons;
    }

    public int[] chooseRandomSpawn(int playerX, int playerY, int spawnDistance, int spawnRange){
        int whichCoordinateOutside = rnd.nextInt(0, 4);
        int spawnX;
        int spawnY;

        switch(whichCoordinateOutside) {
            case 0:
                spawnX = rnd.nextInt(playerX - spawnDistance - spawnRange, playerX - spawnDistance);
                spawnY = rnd.nextInt(-spawnDistance, spawnDistance);
                break;
            case 1:
                spawnX = rnd.nextInt(playerX + spawnDistance, playerX + spawnDistance + spawnRange);
                spawnY = rnd.nextInt(-spawnDistance, spawnDistance);
                break;
            case 2:
                spawnY = rnd.nextInt(playerY - spawnDistance - spawnRange, playerY - spawnDistance);
                spawnX = rnd.nextInt(-spawnDistance, spawnDistance);
                break;
            case 3:
                spawnY = rnd.nextInt(playerY + spawnDistance, playerY + spawnDistance + spawnRange);
                spawnX = rnd.nextInt(-spawnDistance, spawnDistance);
                break;
            default:
                spawnX = spawnDistance;
                spawnY = spawnDistance;
        }

        int[] spawnCoordinates = new int[2];
        spawnCoordinates[0] = spawnX;
        spawnCoordinates[1] = spawnY;

        return spawnCoordinates;
    }
}
