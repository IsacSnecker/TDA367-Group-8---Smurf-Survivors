package com.smurfsurvivors.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.*;
import com.smurfsurvivors.game.model.entity.*;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import com.smurfsurvivors.game.model.weapons.AbstractWeapon;
import com.smurfsurvivors.game.model.weapons.MagicHandler;
import com.smurfsurvivors.game.model.weapons.MissileHandler;
import com.smurfsurvivors.game.model.weapons.WeaponInformationHandler;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GameModel implements Observable {

    private ArrayList<Observer> observerList;
    private PlayerCharacter player;
    public EnemyHandler enemyHandler;
    private CollisionHandler collisionHandler;

    private FoodHandler foodHandler;

    private Difficulty difficulty;
    private Clock clock;

    private Music soundTrack;

    private Boolean isPaused = true;

    private Boolean isGameOver = false;

    public GameModel(Difficulty difficulty){

        this.difficulty = difficulty;
        this.collisionHandler = new CollisionHandler();
        this.observerList = new ArrayList<Observer>();
        this.enemyHandler = new EnemyHandler();
        this.clock = new Clock();
        this.foodHandler = new FoodHandler(100, this);


        soundTrack = Gdx.audio.newMusic(Gdx.files.internal("Sounds/Hallonsaft.mp3")); //
        soundTrack.setLooping(true);
        soundTrack.play(); //Should probably not be here
        soundTrack.setVolume(0.7f);


        clock.startClock();
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

    public void init(PlayerCharacter player){
        setPlayer(player);
        initCollisionHandler(player);
    }
    private void initCollisionHandler(PlayerCharacter player){
        collisionHandler.init(player, enemyHandler, foodHandler);
    }
    public PlayerCharacter getPlayer(){
        return this.player;
    }

    public Clock getClock(){
        return this.clock;
    }

    public Boolean getIsPaused(){
        return this.isPaused;
    }

    public void setPlayer(PlayerCharacter player) { this.player = player; }

    public void togglePaused(){
        isPaused = !isPaused;
        if(isPaused){
            clock.pauseClock();
        }
        else {
            clock.resumeClock();
        }
    }

    public void setMusicVolume(float musicVolume){
        soundTrack.setVolume(musicVolume);
    }


    public Difficulty getDifficulty(){
        return this.difficulty;
    }
    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public void updatePlayerPosition(ArrayList<Integer> inputList){
        if(!isPaused){
            player.updatePosition(inputList);
        }
    }

    public void updateEnemyPositions(){
        for (Enemy enemy : getEnemies()) {
            enemy.moveTowardsEntity(player);
        }
    }

    public void playerFoodCollision(){
        collisionHandler.handleFoodCollision(foodHandler.getFoods());
    }

    public void update() {
        if(!isPaused){
            updateEnemyPositions();
            if(player.getHealth() <= 0){
                setIsGameOver();
            }
            if(!getEnemies().isEmpty()){
                player.WHandler.weaponInformationHandler.updateWeaponInformation(player.getDirection(), getNearestEnemyPosition(), getNearestEnemy());
                player.usePassiveWeapon();
                player.WHandler.updateWeaponCooldowns();
                enemyPlayerCollision();
                enemyProjectileCollision();
                playerFoodCollision();
                foodHandler.update();
            }
            enemyHandler.spawnNewEnemies(clock.getTimeSeconds(), player.getX(), player.getY(), difficulty.getSpawnRateMultiplier());
            enemyHandler.updateEnemies(player); //gör till koordinater istället för entity
        }
        notifyObservers();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemyHandler.getEnemies();
    }

    public ArrayList<Food> getFoods() {return foodHandler.getFoods();}

    public Vector2 getNearestEnemyPosition(){
        return getNearestEnemy().getPosition();
    }

    public Enemy getNearestEnemy(){
        ArrayList<Enemy> enemyList = getEnemies();
        Enemy nearestEnemy = enemyList.get(0);
        for(Enemy enemy: enemyList){
            if(calculateDistance(enemy.getPosition(), player.getPosition()) < calculateDistance(nearestEnemy.getPosition(), player.getPosition())){
                nearestEnemy = enemy;
            }
        }
        return nearestEnemy;
    }

    public void enemyProjectileCollision(){
        collisionHandler.handleIfCollision(player.WHandler.getProjectiles(), getEnemies());
    }

    public void enemyPlayerCollision(){
        collisionHandler.handleIfCollision(getEnemies());
    }

    public void setIsGameOver(){
        this.isGameOver = true;
    }
    public boolean getIsGameOver(){
        return this.isGameOver;
    }

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }
}
