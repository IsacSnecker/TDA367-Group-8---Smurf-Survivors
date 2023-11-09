package com.smurfsurvivors.game;

import com.smurfsurvivors.game.entity.*;

import java.util.ArrayList;

public class GameModel implements IGameModel, Observer{
    //private PlayerCharacter player;
    private ArrayList<Enemy> enemyList;

    public GameModel(){
        this.enemyList = new ArrayList<Enemy>();
        //this.player = new PlayerCharacter();

    }

    public void updatePlayerPosition(){
        //player.updatePosition
    }
    public void updateEnemyPositions(){
        for (Enemy enemy : enemyList) {
            //enemy.updatePosition();
        }
    }

    @Override
    public void update() {
        //updatePlayerPosition
        updateEnemyPositions();
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemyList;
    }

}
