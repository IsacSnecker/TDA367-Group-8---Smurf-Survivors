package com.smurfsurvivors.game;
import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.Gargamel;
import com.smurfsurvivors.game.entity.PlayerCharacter;

import java.util.ArrayList;
import java.util.Random;


public class EnemyHandler {
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    private EnemyFactory enemyFactory;
    private boolean spawnReady;
    private double spawnRate;
    Random rnd = new Random();

    public EnemyHandler(){
        //this.enemyFactory = new EnemyFactory();
        this.spawnReady = true;
        this.spawnRate = 5;
    }

    public void spawnDemons(int numDemons, float playerX, float playerY){
        enemyList.addAll(enemyFactory.makeDemons(numDemons, playerX, playerY));
    }

    public void spawnGargamels(int numGargamels, float playerX, float playerY) {
        enemyList.addAll(enemyFactory.makeGargamels(numGargamels, playerX, playerY));

    }

    public void updateEnemies(PlayerCharacter player){
        ArrayList<Enemy> enemiesToRemove = new ArrayList<Enemy>();
        for(Enemy enemy: enemyList){
            if(enemy.getHealth() > 0){
                enemy.moveTowardsEntity(player);
            } else {
                enemiesToRemove.add(enemy);
            }
        }
        enemyList.removeAll(enemiesToRemove);
        enemiesToRemove.clear();
    }

    public ArrayList<Enemy> getEnemies(){
        return enemyList;
    }

    public void spawnNewEnemies(long seconds, float playerX, float playerY, double spawnRateMultiplier){
        if (seconds % 10 != 0){
            spawnReady = true;
        }
        if (seconds % 10 == 0 && spawnReady){
            spawnDemons((int) spawnRate, playerX, playerY);
            /*if (rnd.nextInt(0,2) == 1){
                spawnGargamels((int) spawnRate / 2, playerX, playerY);
            }*/
            spawnGargamels(1, playerX, playerY);
            spawnReady = false;
            spawnRate = spawnRate * spawnRateMultiplier;
        }
    }

    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }
    public void removeEnemy(Enemy enemy){
        enemyList.remove(enemy);
    }
}
