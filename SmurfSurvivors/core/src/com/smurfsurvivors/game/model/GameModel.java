package com.smurfsurvivors.game.model;

import com.smurfsurvivors.game.*;
import com.smurfsurvivors.game.model.clock.Clock;
import com.smurfsurvivors.game.model.entity.*;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import com.smurfsurvivors.game.model.handlers.CollisionHandler;
import com.smurfsurvivors.game.model.handlers.EnemyHandler;
import com.smurfsurvivors.game.model.handlers.FoodHandler;

import java.util.ArrayList;

public class GameModel implements Observable {

    private ArrayList<Observer> observerList;
    private PlayerCharacter player;

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

        initializeObservers();

    }

    public void init(PlayerCharacter player){
        this.enemyHandler = new EnemyHandler(this);
        this.foodHandler = new FoodHandler(500);

        this.collisionHandler = new CollisionHandler(player, enemyHandler, foodHandler, this);
        setPlayer(player);
        //audioManager.playSong("soundtrack");

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
            enemyHandler.updateEnemies(); //gör till koordinater istället för entity
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

    /*public void setMusicVolume(float volume) {
        audioManager.setMusicVolume(volume);
    }

    public void setSoundEffectVolume(float volume) {
        audioManager.setSoundVolume(volume);
    }

    public IAudioManager getAudioManager() {
        return this.audioManager;
    }*/

    public CollisionHandler getCollisionHandler() {
        return collisionHandler;
    }

    public void setIsGameOver(){
        this.isGameOver = true;
    }
    public boolean getIsGameOver(){
        return this.isGameOver;
    }

}
