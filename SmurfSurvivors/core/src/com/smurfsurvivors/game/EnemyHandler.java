package com.smurfsurvivors.game;
import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.PlayerCharacter;

import java.util.ArrayList;

public class EnemyHandler {
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    private EnemyFactory enemyFactory;

    public EnemyHandler(){
        this.enemyFactory = new EnemyFactory();
    }

    public void spawnDemons(int numDemons, int playerX, int playerY){
        for (Enemy demon : enemyFactory.makeDemons(numDemons, playerX, playerY)){
            enemyList.add(demon);
        }
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
    }
    public ArrayList<Enemy> getEnemies(){
        return enemyList;
    }

    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }
}
