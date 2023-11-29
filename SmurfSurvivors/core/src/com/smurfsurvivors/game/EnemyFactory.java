package com.smurfsurvivors.game;

import com.smurfsurvivors.game.model.entity.Demon;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.Gargamel;

import java.util.ArrayList;
import java.util.Random;

public abstract class EnemyFactory {

    static Random rnd = new Random();
    static int spawnDistance = 1500;
    static int spawnRange = 2000;

    public static ArrayList<Enemy> makeDemons(int numDemons, float playerX, float playerY){
        ArrayList<Enemy> demons = new ArrayList<Enemy>();
        for (int i = 0; i < numDemons; i++){
            int[] spawnCoordinates = chooseSpawnCoordinates(playerX, playerY);
            demons.add(new Demon(spawnCoordinates[0], spawnCoordinates[1]));
        }
        return demons;
    }

    public static ArrayList<Enemy> makeGargamels(int numGargamels, float playerX, float playerY){
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

    private static int[] chooseSpawnCoordinates(float _playerX, float _playerY){
        int whichCoordinateOutside = rnd.nextInt(0, 4);
        int spawnX;
        int spawnY;
        int playerX = (int) _playerX;
        int playerY = (int) _playerY;

        switch(whichCoordinateOutside) {
            case 0:
                spawnX = rnd.nextInt(playerX - spawnDistance - spawnRange, playerX - spawnDistance);
                spawnY = rnd.nextInt(playerY - spawnDistance, playerY + spawnDistance);
                break;
            case 1:
                spawnX = rnd.nextInt(playerX + spawnDistance, playerX + spawnDistance + spawnRange);
                spawnY = rnd.nextInt(playerY - spawnDistance, playerY + spawnDistance);
                break;
            case 2:
                spawnY = rnd.nextInt(playerY - spawnDistance - spawnRange, playerY - spawnDistance);
                spawnX = rnd.nextInt(playerX - spawnDistance, playerX + spawnDistance);
                break;
            case 3:
                spawnY = rnd.nextInt(playerY + spawnDistance, playerY + spawnDistance + spawnRange);
                spawnX = rnd.nextInt(playerX - spawnDistance, playerX + spawnDistance);
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
