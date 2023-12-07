package com.smurfsurvivors.game.model;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.smurfsurvivors.game.*;
import com.smurfsurvivors.game.model.clock.Clock;
import com.smurfsurvivors.game.model.entity.*;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import com.smurfsurvivors.game.model.handlers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GameModel implements Observable {

    private ArrayList<Observer> observerList;
    private PlayerCharacter player;

    private ICompositeHandler compositeHandler;

    private Difficulty difficulty;
    private Clock clock;

    private Stage pauseMenu;
    private Stage settingsMenu;
    private Stage mainMenu;

    private Map<Stage, Boolean> stageOpenMap;

    private Boolean isPaused = true;

    private Boolean isGameOver = false;

    public GameModel(Difficulty difficulty, PlayerCharacter player){
        this.difficulty = difficulty;
        this.player = player;
        this.observerList = new ArrayList<Observer>();
        this.clock = new Clock();
        clock.startClock();
        stageInit();

        initializeObservers();

    }

    public void update() {
        notifyObservers();

        if(!isPaused){

            compositeHandler.updateHandlers(clock, player, difficulty);

            if(player.getHealth() <= 0){
                setIsGameOver();
            }

            player.performAttack(compositeHandler.getEnemyHandler());


        }


    }

    public void stageInit(){
        this.pauseMenu = MenuFactory.createPauseMenu();
        this.settingsMenu = MenuFactory.createSettingsMenu();
        this.mainMenu = MenuFactory.createMainMenu();
        stageOpenMap = new HashMap<>();
        stageOpenMap.put(this.pauseMenu, Boolean.FALSE);
        stageOpenMap.put(this.settingsMenu, Boolean.FALSE);
        stageOpenMap.put(this.mainMenu, Boolean.TRUE);
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


    public ArrayList<Enemy> getEnemies() {
        return compositeHandler.getEnemyHandler().getEnemies();
    }

    public ArrayList<Food> getFoods() {return compositeHandler.getFoodHandler().getFoods();}

    public ArrayList<Entity> getEntities() {
        ArrayList<Entity> entities = new ArrayList<>();

        entities.addAll(getEnemies());
        entities.addAll(getFoods());
        entities.add(player);

        return entities;
    }

    public ICollisionHandler getCollisionHandler() {
        return compositeHandler.getCollisionHandler();
    }

    public void setIsGameOver(){
        this.isGameOver = true;
    }
    public boolean getIsGameOver(){
        return this.isGameOver;
    }

    public void setCompositeHandler(ICompositeHandler compositeHandler) {
        this.compositeHandler = compositeHandler;
    }

    public boolean getIsOpen(Stage stage) {
        return stageOpenMap.get(stage);
    }

    private void setIsOpen(Stage stage, Boolean isOpen){
        stageOpenMap.put(stage, isOpen);
    }

    public void switchMenu(Stage stage){
        if(stage != settingsMenu){
            for(Stage key : stageOpenMap.keySet()){
                setIsOpen(key, false);
            }
        }
        setIsOpen(stage, true);
    }

    public Actor getActor(Stage stage, String name){
        return stage.getRoot().findActor(name);
    }

    public Stage getPauseMenu(){
        return this.pauseMenu;
    }

    public Stage getSettingsMenu(){
        return this.settingsMenu;
    }

    public Stage getMainMenu(){
        return this.mainMenu;
    }
    public LevelHandler gePlayertLevelHandler() { return player.getLevelHandler(); }
}
