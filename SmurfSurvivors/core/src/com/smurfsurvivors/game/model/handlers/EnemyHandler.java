package com.smurfsurvivors.game.model.handlers;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import com.smurfsurvivors.game.model.factories.EnemyFactory;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.entity.Enemy;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class EnemyHandler implements IEnemyHandler {

    PlayerCharacter player;
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    private boolean spawnReady;
    private double spawnRate;
    Random rnd = new Random();

    public EnemyHandler(PlayerCharacter player){
        this.spawnReady = true;
        this.spawnRate = 1;
        this.player = player;
    }

    private void spawnDemons(int numDemons, float playerX, float playerY){
        enemyList.addAll(EnemyFactory.makeDemons(numDemons, playerX, playerY));
    }

    private void spawnGargamels(int numGargamels, float playerX, float playerY) {
        enemyList.addAll(EnemyFactory.makeGargamels(numGargamels, playerX, playerY));
    }

    private void spawnNemesises(int numNemesises, float playerX, float playerY){
        enemyList.addAll(EnemyFactory.makeNemesises(numNemesises, playerX, playerY));
    }

    private void spawnPurpleSmurfs(int numPurpleSmurfs, float playerX, float playerY){
        enemyList.addAll(EnemyFactory.makePurpleSmurfs(numPurpleSmurfs, playerX, playerY));

    }

    public void updateEnemies(){
        ArrayList<Enemy> enemiesToRemove = new ArrayList<Enemy>();
        for(Enemy enemy: enemyList){
            if(enemy.getHealth() > 0){
                enemy.moveTowardsEntity(player);
            } else {
                enemiesToRemove.add(enemy);
                enemy.setIsDead(true);
            }
        }
        enemyList.removeAll(enemiesToRemove);
        enemiesToRemove.clear();
    }

    public ArrayList<Enemy> getEnemies(){
        return enemyList;
    }

    public void spawnNewEnemies(long seconds, float playerX, float playerY, double spawnRateAdd){
        if (seconds % 2 != 0){
            spawnReady = true;
        }
        if (seconds % 2 == 0 && spawnReady){
            spawnDemons((int) spawnRate, playerX, playerY);
            spawnPurpleSmurfs((int) spawnRate*3, playerX, playerY);
            if (rnd.nextInt(0,10) == 0){
                spawnGargamels((int) spawnRate, playerX, playerY);
            }
            if (rnd.nextInt(0,5) == 0){
                spawnNemesises((int) spawnRate, playerX, playerY);
            }
            spawnReady = false;
            spawnRate += spawnRateAdd;
        }
    }

    public Enemy getNearestEnemy(){
        ArrayList<Enemy> enemyList = getEnemies();
        Enemy nearestEnemy = enemyList.get(0);
        for(Enemy enemy: enemyList){
            if(calculateDistance(enemy.getPosition(), player.getPosition()) < calculateDistance(nearestEnemy.getPosition(), player.getPosition())){
                nearestEnemy = enemy;
            }
        }
        return nearestEnemy;
    }

    private double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }

    public void removeEnemy(Enemy enemy){
        enemyList.remove(enemy);
    }
}
