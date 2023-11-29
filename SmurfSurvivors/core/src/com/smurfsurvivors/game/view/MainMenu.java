package com.smurfsurvivors.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenu {
    Stage stage;

    Image backgroundImage;
    public Button quitButton;
    public Button settingsButton;
    public Button startButton;

    public boolean isOpen = true;
    public MainMenu(Stage stage){
        this.stage = stage;
        Texture backgroundTexture = new Texture("BackgroundTextures/MenuScreen.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Skin skin = new Skin(Gdx.files.internal("Skins/skin/uiskin.json"));
        quitButton = new TextButton("QUIT",skin);
        quitButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        quitButton.setPosition(0,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        settingsButton = new TextButton("SETTINGS",skin);
        settingsButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        settingsButton.setPosition(Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);

        startButton = new TextButton("START",skin);
        startButton.setSize(2 * Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        startButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/5)/2,(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10)/2);

        stage.addActor(backgroundImage);
        stage.addActor(quitButton);
        stage.addActor(settingsButton);
        stage.addActor(startButton);
    }

    public void render(){
        stage.draw();
    }

}
