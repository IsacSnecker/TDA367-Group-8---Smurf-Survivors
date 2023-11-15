package com.smurfsurvivors.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.entity.*;
import com.smurfsurvivors.game.weapons.AbstractWeapon;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GameModel implements Observable{

    private ArrayList<Observer> observerList;
    private PlayerCharacter player;
    private ArrayList<Enemy> enemyList;
    public EnemyHandler enemyHandler;
    private CollisionHandler collisionHandler;

    public GameModel(){
        this.collisionHandler = new CollisionHandler();
        this.observerList = new ArrayList<Observer>();
        enemyHandler = new EnemyHandler();
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
        enemyHandler.addEnemy(enemy);
    }

    public void setPlayer(PlayerCharacter player) { this.player = player; }


    public void updatePlayerPosition(ArrayList<Integer> inputList){
        player.updatePosition(inputList);
    }

    public void updateEnemyPositions(){
        for (Enemy enemy : getEnemies()) {
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
        if(!isPaused){
            updateEnemyPositions();
            updatePlayerHealth();
            if(getEnemies().size() > 0){
                player.WHandler.passiveWeaponUpdate(new Vector2(player.getX(),player.getY()),getNearestEnemy());
                enemyProjectileCollision();
            }
            enemyHandler.updateEnemies(player);
        }
        notifyObservers();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemyHandler.getEnemies();
    }

    public Enemy getNearestEnemy(){
        enemyList = getEnemies();
        Enemy nearestEnemy = enemyList.get(0);
        for(Enemy enemy: enemyList){
            if(calculateDistance(new Vector2(enemy.getX(), enemy.getY()), new Vector2(player.getX(), player.getY())) < calculateDistance(new Vector2(nearestEnemy.getX(), nearestEnemy.getY()), new Vector2(player.getX(), player.getY()))){
                nearestEnemy = enemy;
            }
        }
        return nearestEnemy;
    }



    public void enemyProjectileCollision(){
        for(AbstractWeapon projectile : player.WHandler.getProjectiles()){
            for(Enemy enemy : getEnemies()){
                if(projectile.getPositionRectangle().overlaps(enemy.getRectangle())){
                    enemy.damageEntity(enemy);
                    player.WHandler.removeProjectile(projectile);
                }
            }
        }
    }

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }
}
