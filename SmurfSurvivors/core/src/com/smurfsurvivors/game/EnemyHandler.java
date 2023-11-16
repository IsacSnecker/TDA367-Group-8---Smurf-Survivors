package com.smurfsurvivors.game;
import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.PlayerCharacter;

import java.util.ArrayList;
import java.util.Random;

public class EnemyHandler {
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    Random rnd = new Random();

    public EnemyHandler(){

    }

    public void spawnDemon(){
        enemyList.add(new Demon( rnd.nextInt(-5000, 5000), rnd.nextInt(-5000, 5000)));
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
