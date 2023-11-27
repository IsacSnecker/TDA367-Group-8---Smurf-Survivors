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


    public PauseMenu(){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("Skins/skin/uiskin.json"));
        quitButton = new TextButton("QUIT",skin);
        quitButton.setSize(200, 100);
        quitButton.setPosition(0,Gdx.graphics.getHeight()-100);
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
        stage.addActor(quitButton);
    }

    public void render(){
        stage.act();
        stage.draw();
    }
}
