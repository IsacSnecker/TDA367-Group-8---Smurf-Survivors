package com.smurfsurvivors.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class PauseMenu {
    Stage stage;
    Button quitButton;
    Button settingsButton;
    Button resumeButton;


    public PauseMenu(){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("Skins/skin/uiskin.json"));
        quitButton = new TextButton("QUIT",skin);
        quitButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        quitButton.setPosition(0,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        quitButton.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
            }
        });
        settingsButton = new TextButton("SETTINGS",skin);
        settingsButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        settingsButton.setPosition(Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        settingsButton.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //Settings
            }
        });
        resumeButton = new TextButton("RESUME",skin);
        resumeButton.setSize(2 * Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        resumeButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/5)/2,(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10)/2);
        resumeButton.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //Resume
            }
        });
        stage.addActor(quitButton);
        stage.addActor(settingsButton);
        stage.addActor(resumeButton);
    }

    //public void input();

    public void render(){
        stage.act();
        stage.draw();
    }
}
