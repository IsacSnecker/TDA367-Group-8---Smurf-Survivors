package com.smurfsurvivors.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.smurfsurvivors.game.*;
import com.smurfsurvivors.game.model.entity.*;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.LinkedList;

public class GameModel implements Observable {
    private ArrayList<Observer> observerList;
    private PlayerCharacter player;
    private SpriteManager spriteManager;
    private AudioManager audioManager;
    public EnemyHandler enemyHandler;
    private CollisionHandler collisionHandler;
    private FoodHandler foodHandler;
    private Difficulty difficulty;
    private Clock clock;
    private Boolean isPaused = true;
    private Boolean isGameOver = false;


    public GameModel(Difficulty difficulty){
        this.difficulty = difficulty;
        this.observerList = new ArrayList<Observer>();
        this.clock = new Clock();
        clock.startClock();
        this.audioManager = new AudioManager();
        this.spriteManager = new SpriteManager();
        initializeObservers();
    }

    public void init(PlayerCharacter player){
        this.enemyHandler = new EnemyHandler(this);
        this.foodHandler = new FoodHandler(500);
        this.collisionHandler = new CollisionHandler(player, enemyHandler, foodHandler, this);
        setPlayer(player);
        audioManager.playSong("soundtrack");
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

    public void update() {
        if(!isPaused){
            enemyHandler.updateEnemies();
            if(player.getHealth() <= 0){
                setIsGameOver();
            }
            if(!getEnemies().isEmpty()){
                player.WHandler.weaponInformationHandler.updateWeaponInformation(player.getDirection(), enemyHandler.getNearestEnemy().getPosition(), enemyHandler.getNearestEnemy());
                player.usePassiveWeapon();
                player.WHandler.updateWeaponCooldowns();
                collisionHandler.update();
                foodHandler.update();
            }
            enemyHandler.spawnNewEnemies(clock.getTimeSeconds(), player.getX(), player.getY(), difficulty.getSpawnRateAdd());
            enemyHandler.updateEnemies();
        }
        notifyObservers();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemyHandler.getEnemies();
    }

    public ArrayList<Food> getFoods() {return foodHandler.getFoods();}

    public ArrayList<Entity> getEntities() {
        ArrayList<Entity> entities = new ArrayList<>();
        entities.addAll(getEnemies());
        entities.addAll(getFoods());
        entities.add(player);
        return entities;
    }

    public void setMusicVolume(float volume) {
        audioManager.setMusicVolume(volume);
    }
    public void setSoundEffectVolume(float volume) {
        audioManager.setSoundVolume(volume);
    }
    public AudioManager getAudioManager() {
        return this.audioManager;
    }
    public SpriteManager getSpriteManager() { return this.spriteManager; }
    public void setIsGameOver(){
        this.isGameOver = true;
    }
    public boolean getIsGameOver(){
        return this.isGameOver;
    }
}
