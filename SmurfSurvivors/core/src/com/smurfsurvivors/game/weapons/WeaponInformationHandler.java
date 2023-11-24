package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Enemy;

import java.util.Vector;

public class WeaponInformationHandler {
    private int playerDirection;
    private Vector2 enemyPosition;
    private Enemy nearestEnemy;

    public WeaponInformationHandler() {
    }

    public void updateWeaponInformation(int playerDirection, Vector2 enemyPosition, Enemy nearestEnemy){
        this.playerDirection = playerDirection;
        this.enemyPosition = enemyPosition;
        this.nearestEnemy = nearestEnemy;
    }

    public int getPlayerDirection(){
        return playerDirection;
    }
    public Vector2 getEnemyPosition(){
        return enemyPosition;
    }
    public Enemy getNearestEnemy(){
        return nearestEnemy;
    }
}
