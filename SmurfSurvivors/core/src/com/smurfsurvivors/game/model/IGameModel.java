package com.smurfsurvivors.game.model;

import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

import java.util.ArrayList;

public interface IGameModel {
    void update();
    ArrayList<Enemy> getEnemies();
    public PlayerCharacter getPlayer();
    public void setPlayer(PlayerCharacter player);
    public void addEnemy(Enemy enemy);
    public void init();
}
