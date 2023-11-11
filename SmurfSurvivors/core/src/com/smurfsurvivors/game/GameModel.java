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
        this.player = new PlayerCharacter(100, new Texture("Player/smurf-100x100.png"), 0,0, 32,32);
        addEnemy(new Enemy(100, 100, new Texture("Enemies/blueDemon.png"), 100, 100, 32, 32));
        addEnemy(new Enemy(100, 100, new Texture("Enemies/blueDemon.png"), 300, 300, 32, 32));
        addEnemy(new Enemy(100, 100, new Texture("Enemies/blueDemon.png"), 200, 200, 32, 32));
        initializeObservers();
    }

    @Override
    public void initializeObservers() {
        for (Observer o : observerList){
            o.init();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observerList){
            o.update();
        }
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    public PlayerCharacter getPlayer(){
        return this.player;
    }

    public void addEnemy(Enemy enemy) {
        this.enemyList.add(enemy);
    }


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

    public void update(ArrayList<Integer> inputList) {
        updatePlayerPosition(inputList);
        updateEnemyPositions();
        updatePlayerHealth();
        notifyObservers();
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemyList;
    }

}