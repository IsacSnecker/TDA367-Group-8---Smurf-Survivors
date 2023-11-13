package com.smurfsurvivors.game;
import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.PlayerCharacter;

import java.util.ArrayList;

public class EnemyHandler {
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    public void spawnDemon(){
        enemyList.add(new Enemy(100, 100, new Texture("Enemies/blueDemon.png"), 100, 100, 32, 32));
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
}
