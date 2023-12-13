package com.smurfsurvivors.game.model.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.smurfsurvivors.game.model.MenuFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MenuHandler implements IMenuHandler{
    private Map<String, Stage> stageStringMap;
    private Map<Stage, Boolean> stageOpenMap;
    private Stage lastUsed = null;
    private Boolean isPaused = true;

    public MenuHandler(){
        stageInit();
    }

    private void stageInit(){
        Stage pauseMenu = MenuFactory.createPauseMenu();
        Stage settingsMenu = MenuFactory.createSettingsMenu();
        Stage mainMenu = MenuFactory.createMainMenu();
        stageOpenMap = new LinkedHashMap<>();
        stageOpenMap.put(mainMenu, Boolean.TRUE);
        stageOpenMap.put(pauseMenu, Boolean.FALSE);
        stageOpenMap.put(settingsMenu, Boolean.FALSE);
        stageStringMap = new HashMap<>();
        stageStringMap.put("Pause", pauseMenu);
        stageStringMap.put("Main", mainMenu);
        stageStringMap.put("Settings", settingsMenu);
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
        //Stage settingsStage = stageStringMap.get("Settings");
        //stageOpenMap.put(settingsStage, stageOpenMap.get(settingsStage));
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
