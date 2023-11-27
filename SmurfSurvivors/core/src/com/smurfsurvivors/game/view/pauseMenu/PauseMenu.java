package com.smurfsurvivors.game.view.pauseMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.w3c.dom.Text;

public class PauseMenu {
    public Stage stage;
    TextButton quitButton;
    TextButton settingsButton;
    TextButton resumeButton;
    Batch pauseBatch;

    public PauseMenu(Batch batch){
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("Skins/uiskin.json"));
        this.quitButton = new TextButton("QUIT", skin);
        this.quitButton.setSize(200,100);
        this.quitButton.setPosition(0,Gdx.graphics.getHeight() - 100);
        this.quitButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
            }
        });
        this.settingsButton = new TextButton("SETTINGS", skin);
        this.settingsButton.setSize(200,100);
        this.settingsButton.getColor().set(64f, 224f,208f, 1);
        this.settingsButton.setPosition((Gdx.graphics.getWidth()-200),(Gdx.graphics.getHeight()-100));
        this.settingsButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                // Settings
            }
        });
        this.resumeButton = new TextButton("RESUME", skin);
        this.resumeButton.setSize(300,100);
        this.resumeButton.setPosition(((Gdx.graphics.getWidth()-300)/2),((Gdx.graphics.getHeight()-100))/2);
        this.resumeButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                // Settings
            }
        });

        stage.addActor(quitButton);
        stage.addActor(settingsButton);
        stage.addActor(resumeButton);
    }

    public void render(){
        //stage.act();
        stage.draw();
        //quitButton.draw(this.pauseBatch, 1);
    }

}
