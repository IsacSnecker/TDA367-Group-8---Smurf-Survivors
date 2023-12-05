package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.model.entity.Enemy;

import java.util.ArrayList;

public interface IEnemyHandler {

    void updateEnemies();

    ArrayList<Enemy> getEnemies();

    void spawnNewEnemies(long seconds, float playerX, float playerY, double spawnRateAdd);

    Enemy getNearestEnemy();

    void removeEnemy(Enemy enemy);

}
