package com.smurfsurvivors.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class PauseMenu {
    Stage stage;
    private Button quitButton;
    private Button settingsButton;
    private Button resumeButton;


    public PauseMenu(Stage stage) {
        this.stage = stage;
        Skin skin = new Skin(Gdx.files.internal("Skins/skin/uiskin.json"));
        quitButton = new TextButton("QUIT", skin);
        quitButton.setSize(Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 10);
        quitButton.setPosition(0, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 10);
        settingsButton = new TextButton("SETTINGS", skin);
        settingsButton.setSize(Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 10);
        settingsButton.setPosition(Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 10);

        resumeButton = new TextButton("RESUME", skin);
        resumeButton.setSize(2 * Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 10);
        resumeButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 5) / 2, (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 10) / 2);

        stage.addActor(quitButton);
        stage.addActor(settingsButton);
        stage.addActor(resumeButton);
    }

    //public void input();

    public void render() {
        stage.draw();
    }

    public Button getQuitButton(){
        return this.quitButton;
    }

    public Button getSettingsButton(){
        return this.settingsButton;
    }

    public Button getResumeButton(){
        return this.resumeButton;
    }

    public Stage getStage(){
        return stage;
    }
}
