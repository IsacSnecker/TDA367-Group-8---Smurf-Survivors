package com.smurfsurvivors.game.model.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.smurfsurvivors.game.model.MenuFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuHandler implements IMenuHandler{
    private Stage pauseMenu;
    private Stage settingsMenu;
    private Stage mainMenu;
    private Map<String, Stage> stageStringMap;
    private Map<Stage, Boolean> stageOpenMap;
    private Stage lastUsed = null;
    private Boolean isPaused = true;

    public MenuHandler(){
        stageInit();
    }

    public void stageInit(){
        this.pauseMenu = MenuFactory.createPauseMenu();
        this.settingsMenu = MenuFactory.createSettingsMenu();
        this.mainMenu = MenuFactory.createMainMenu();
        stageOpenMap = new HashMap<>();
        stageOpenMap.put(this.settingsMenu, Boolean.FALSE);
        stageOpenMap.put(this.pauseMenu, Boolean.FALSE);
        stageOpenMap.put(this.mainMenu, Boolean.TRUE);
        stageStringMap = new HashMap<>();
        stageStringMap.put("Settings", this.settingsMenu);
        stageStringMap.put("Pause", this.pauseMenu);
        stageStringMap.put("Main", this.mainMenu);
    }

    public void switchMenu(String stageString){
        lastUsed = (Stage) Gdx.input.getInputProcessor();
        if(!Objects.equals(stageString, "Settings")){
            for(Stage stage : stageOpenMap.keySet()){
                System.out.println();
                setIsOpen(stage, false);
            }
        }
        if(!Objects.equals(stageString, "")) {
            setIsOpen(stageStringMap.get(stageString), true);
        }
        Gdx.input.setInputProcessor(stageStringMap.get(stageString));
    }

    public void closeMenu(){
        setIsOpen((Stage) Gdx.input.getInputProcessor(), false);
        Gdx.input.setInputProcessor(lastUsed);
        lastUsed = null;
    }

    public Stage getMenu(String stageString){
        return stageStringMap.get(stageString);
    }

    public boolean getIsOpen(Stage stage) {
        return stageOpenMap.get(stage);
    }

    private void setIsOpen(Stage stage, Boolean isOpen){
        stageOpenMap.put(stage, isOpen);
    }

    public Stage getMainMenu() {
        return mainMenu;
    }

    public Stage getPauseMenu() {
        return pauseMenu;
    }

    public Stage getSettingsMenu() {
        return settingsMenu;
    }

    public Map<Stage, Boolean> getStageOpenMap(){
        return this.stageOpenMap;
    }

    public Boolean getIsPaused(){
        return this.isPaused;
    }

    public void setIsPaused(Boolean paused){
        this.isPaused = paused;
    }
}
