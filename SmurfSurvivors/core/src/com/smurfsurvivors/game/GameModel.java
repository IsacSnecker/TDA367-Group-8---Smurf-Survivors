package com.smurfsurvivors.game;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.*;

import java.util.ArrayList;

public class GameModel implements Observable{

    private ArrayList<Observer> observerList;
    private PlayerCharacter player;
    private ArrayList<Enemy> enemyList;

    private CollisionHandler collisionHandler;

    public GameModel(){
        this.enemyList = new ArrayList<Enemy>();
        this.collisionHandler = new CollisionHandler();
        this.observerList = new ArrayList<Observer>();
    }

    public void init(){
        initializeObservers();
    }

    @Override
    public void initializeObservers() {
        for (Observer o : observerList){
            o.observerInit();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observerList){
            o.observerUpdate();
        }
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) { observerList.remove(o);}

    public PlayerCharacter getPlayer(){
        return this.player;
    }

    public void addEnemy(Enemy enemy) {
        this.enemyList.add(enemy);
    }

    public void setPlayer(PlayerCharacter player) { this.player = player; }


    public void updatePlayerPosition(ArrayList<Integer> inputList){
        player.updatePosition(inputList);
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
        updateEnemyPositions();
        updatePlayerHealth();
        notifyObservers();
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemyList;
    }

}