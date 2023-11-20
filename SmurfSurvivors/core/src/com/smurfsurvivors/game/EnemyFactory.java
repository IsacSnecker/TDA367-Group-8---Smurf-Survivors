package com.smurfsurvivors.game;

import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.Gargamel;

import java.util.ArrayList;
import java.util.Random;

public class EnemyFactory {
    Random rnd = new Random();
    int spawnDistance = 1500;
    int spawnRange = 2000;
    public EnemyFactory(){

    }

    public ArrayList<Enemy> makeDemons(int numDemons, int playerX, int playerY){
        ArrayList<Enemy> demons = new ArrayList<Enemy>();
        for (int i = 0; i < numDemons; i++){
            int[] spawnCoordinates = chooseSpawnCoordinates(playerX, playerY);
            demons.add(new Demon(spawnCoordinates[0], spawnCoordinates[1]));
        }
        return demons;
    }

    public ArrayList<Enemy> makeGargamels(int numGargamels, int playerX, int playerY){
        ArrayList<Enemy> gargamels = new ArrayList<Enemy>();
        for (int i = 0; i < numGargamels; i++){
            int[] spawnCoordinates = chooseSpawnCoordinates(playerX, playerY);
            gargamels.add(new Gargamel(spawnCoordinates[0], spawnCoordinates[1]));
        }
        return gargamels;
    }

    /*
    public <T extends Enemy> ArrayList<T> makeEnemiesOfType(Class<T> type, int numEnemies, int playerX, int playerY) throws InstantiationException, IllegalAccessException {
        ArrayList<T> enemies = new ArrayList<T>();
        for (int i = 0; i < numEnemies; i++){
            int[] spawnCoordinates = chooseSpawnCoordinates(playerX, playerY);
            T enemy = (T) type.newInstance();
            enemy.setX(spawnCoordinates[0]);
            enemy.setY(spawnCoordinates[1]);
            enemies.add(enemy);
        }
        return enemies;
    }
    */

    private int[] chooseSpawnCoordinates(int playerX, int playerY){
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
