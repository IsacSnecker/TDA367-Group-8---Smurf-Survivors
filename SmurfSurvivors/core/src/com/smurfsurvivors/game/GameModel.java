package com.smurfsurvivors.game;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.*;

import java.util.ArrayList;

public class GameModel implements IGameModel{

    private PlayerCharacter player;
    private ArrayList<Enemy> enemyList;

    private CollisionHandler collisionHandler;

    public GameModel(){
        this.enemyList = new ArrayList<Enemy>();
        this.collisionHandler = new CollisionHandler();
    }


    public PlayerCharacter getPlayer(){
        return this.player;
    }
    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }

    public void addEnemy(Enemy enemy) {
        this.enemyList.add(enemy);
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

    public void update() {
        updatePlayerPosition();
        updateEnemyPositions();
        updatePlayerHealth();
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemyList;
    }

}
