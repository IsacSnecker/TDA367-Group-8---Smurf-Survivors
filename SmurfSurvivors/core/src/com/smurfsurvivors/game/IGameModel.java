package com.smurfsurvivors.game;

import com.smurfsurvivors.game.entity.Enemy;

import java.util.ArrayList;

public interface IGameModel {
    void update();
    ArrayList<Enemy> getEnemies();
}
