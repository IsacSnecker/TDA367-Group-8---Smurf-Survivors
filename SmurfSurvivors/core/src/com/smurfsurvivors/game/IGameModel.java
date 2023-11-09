package com.smurfsurvivors.game;

import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.PlayerCharacter;

import java.util.ArrayList;

public interface IGameModel {

    public void setPlayer(PlayerCharacter player);
    public void addEnemy(Enemy enemy);

    public ArrayList<Enemy> getEnemies();

}
