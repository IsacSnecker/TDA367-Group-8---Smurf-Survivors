package com.smurfsurvivors.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class EnemyHandler {

    GameModel model;
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    private boolean spawnReady;
    private double spawnRate;
    Random rnd = new Random();

    public EnemyHandler(GameModel model){
        this.spawnReady = true;
        this.spawnRate = 4;
        this.model = model;
    }

    public void spawnDemons(int numDemons, float playerX, float playerY){
        enemyList.addAll(EnemyFactory.makeDemons(numDemons, playerX, playerY));
    }

    public void spawnGargamels(int numGargamels, float playerX, float playerY) {
        enemyList.addAll(EnemyFactory.makeGargamels(numGargamels, playerX, playerY));

    }

    public void updateEnemies(PlayerCharacter player){
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

    public void spawnNewEnemies(long seconds, float playerX, float playerY, double spawnRateMultiplier){
        if (seconds % 10 != 0){
            spawnReady = true;
        }
        if (seconds % 10 == 0 && spawnReady){
            spawnDemons((int) spawnRate, playerX, playerY);
            if (rnd.nextInt(0,2) == 1){
                spawnGargamels((int) spawnRate / 4, playerX, playerY);
            }
            spawnReady = false;
            spawnRate = spawnRate * spawnRateMultiplier;
        }
    }

    public Enemy getNearestEnemy(){
        ArrayList<Enemy> enemyList = getEnemies();
        Enemy nearestEnemy = enemyList.get(0);
        for(Enemy enemy: enemyList){
            if(calculateDistance(enemy.getPosition(), model.getPlayer().getPosition()) < calculateDistance(nearestEnemy.getPosition(), model.getPlayer().getPosition())){
                nearestEnemy = enemy;
            }
        }
        return nearestEnemy;
    }

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }

    public Vector2 getNearestEnemyPosition(){
        return getNearestEnemy().getPosition();
    }

    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }
    public void removeEnemy(Enemy enemy){
        enemyList.remove(enemy);
    }
}
