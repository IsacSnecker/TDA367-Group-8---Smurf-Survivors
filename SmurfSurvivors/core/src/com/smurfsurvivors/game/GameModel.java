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
    private EnemyHandler enemyHandler;
    private CollisionHandler collisionHandler;

    public GameModel(){
        this.enemyList = new ArrayList<Enemy>();
        this.collisionHandler = new CollisionHandler();
        this.observerList = new ArrayList<Observer>();
    }

    public void init(){
        this.player = new PlayerCharacter(100, new Texture("Player/smurf-100x100.png"), 0,0, 32,32);
        enemyHandler = new EnemyHandler();
        enemyHandler.spawnDemon();
        enemyHandler.spawnDemon();
        enemyHandler.spawnDemon();
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
        player.WHandler.projectilesTowardsEntity(getNearestEnemy());
        enemyProjectileCollision();
        enemyHandler.updateEnemies(player);
        notifyObservers();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemyHandler.getEnemies();
    }


    public Entity getNearestEnemy(){
        Entity nearestEnemy = getEnemies().get(0);
        for(Enemy enemy: getEnemies()){
             if(calculateDistance(new Vector2(enemy.getX(), enemy.getY()), new Vector2(player.getX(), player.getY())) < calculateDistance(new Vector2(nearestEnemy.getX(), nearestEnemy.getY()), new Vector2(player.getX(), player.getY()))){
                 nearestEnemy = enemy;
            }
        }
        return nearestEnemy;
    }



    public void enemyProjectileCollision(){
        for(AbstractWeapon projectile : player.WHandler.getProjectiles()){
            for(Enemy enemy : getEnemies()){
                if(projectile.getPositionRectangle().contains(enemy.getRectangle())){
                    enemy.damageEntity(enemy, projectile.attackDamage);
                    player.WHandler.removeProjectile(projectile);
                }
            }
        }
    }

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }

}
