package com.smurfsurvivors.game.model.handlers;

import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Map;

public interface IMenuHandler {
    public Boolean getIsPaused();
    public void setIsPaused(Boolean paused);
    public void switchMenu(String menuString);
    public void closeMenu();
    public Stage getMenu(String menuString);
    public Map<Stage,Boolean> getStageOpenMap();
}
