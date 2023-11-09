package com.smurfsurvivors.game;

import com.smurfsurvivors.game.entity.*;

import java.util.ArrayList;

public class GameModel implements IGameModel{

    private PlayerCharacter player;
    private ArrayList<Enemy> enemyList;

    private CollisionHandler collisionHandler;

    public GameModel(){
        this.enemyList = new ArrayList<Enemy>();
        this.collisionHandler = new CollisionHandler();
        //this.player = new PlayerCharacter();

    }

    public void updatePlayerPosition(){
        //player.updatePosition();
    }

    public void updateEnemyPositions(){
        for (Enemy enemy : enemyList) {
            enemy.moveTowardsEntity(player);
        }
    }

    public void updatePlayerHealth(){
        /*
        for (Enemy enemy : enemyList){
            if (collisionHandler.isCollision(player, enemy)){
                player.decreaseHealth();
            }
        }
        for (Food food : foodList){
            if (collisionHandler.isCollision(player, food)){
                player.increaseHealth();
                pop food from list
            }
        }
        */
    }

    @Override
    public void update() {
        updatePlayerPosition();
        updateEnemyPositions();
        updatePlayerHealth();
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemyList;
    }

}
