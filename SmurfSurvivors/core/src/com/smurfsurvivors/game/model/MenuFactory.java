package com.smurfsurvivors.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class MenuFactory {
    public static Stage createMainMenu(){
        Stage mainMenu = new Stage();
        Texture backgroundTexture = new Texture("BackgroundTextures/MenuScreen.png");
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setBounds(0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Skin skin = new Skin(Gdx.files.internal("Skins/skin/uiskin.json"));

        Button quitButton = new TextButton("QUIT",skin);
        quitButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        quitButton.setPosition(0,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        quitButton.setColor(1f,0.1f,0.1f,1f);
        quitButton.setName("Quit");

        Button settingsButton = new TextButton("SETTINGS",skin);
        settingsButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        settingsButton.setPosition(Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        settingsButton.setName("Settings");

        Button startButton = new TextButton("START",skin);
        startButton.setSize(2 * Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        startButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/5)/2,(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10)/2);
        startButton.setColor(0.1f,1f,0.1f,1f);
        startButton.setName("Start");

        mainMenu.addActor(backgroundImage);
        mainMenu.addActor(quitButton);
        mainMenu.addActor(settingsButton);
        mainMenu.addActor(startButton);

        return mainMenu;
    }

    public static Stage createPauseMenu(){
        Stage pauseMenu = new Stage();
        Skin skin = new Skin(Gdx.files.internal("Skins/skin/uiskin.json"));

        Button quitButton = new TextButton("QUIT", skin);
        quitButton.setSize(Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 10);
        quitButton.setPosition(0, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 10);
        quitButton.setName("Quit");
        quitButton.setColor(1f,0.1f,0.1f,1f);

        Button settingsButton = new TextButton("SETTINGS", skin);
        settingsButton.setSize(Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 10);
        settingsButton.setPosition(Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 10);
        settingsButton.setName("Settings");

        Button resumeButton = new TextButton("RESUME", skin);
        resumeButton.setSize(2 * Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 10);
        resumeButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 5) / 2, (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 10) / 2);
        resumeButton.setName("Resume");

        pauseMenu.addActor(quitButton);
        pauseMenu.addActor(settingsButton);
        pauseMenu.addActor(resumeButton);
        return pauseMenu;
    }
    public static Stage createSettingsMenu(){
        Stage settingsMenu = new Stage();
        Group group = new Group();
        Skin skin = new Skin(Gdx.files.internal("Skins/skin/uiskin.json"));

        Texture backgroundTexture = new Texture("BackgroundTextures/smurfarna.png");
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setBounds((Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/3)/2,0,Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight());

        Label settingsText = new Label("SETTINGS", skin);
        settingsText.setFontScale(4);
        settingsText.setPosition((Gdx.graphics.getWidth()-4*settingsText.getWidth())/2, Gdx.graphics.getHeight()-4*settingsText.getHeight());

        Slider musicVolumeSlider = new Slider(0, 100, 1, false, skin);
        musicVolumeSlider.setSize(Gdx.graphics.getWidth()/3/2, musicVolumeSlider.getHeight());
        musicVolumeSlider.setPosition((Gdx.graphics.getWidth()-musicVolumeSlider.getWidth())/2, Gdx.graphics.getHeight()/2);
        musicVolumeSlider.setValue(70);
        musicVolumeSlider.setName("Music");
        Label musicLabel = new Label("Music Volume:", skin);
        musicLabel.setPosition((Gdx.graphics.getWidth()-musicVolumeSlider.getWidth())/2 - musicVolumeSlider.getWidth(), Gdx.graphics.getHeight()/2);

        Slider soundVolumeSlider = new Slider(0, 100, 1, false, skin);
        soundVolumeSlider.setPosition((Gdx.graphics.getWidth()-soundVolumeSlider.getWidth())/2, Gdx.graphics.getHeight()/2- musicVolumeSlider.getHeight());
        soundVolumeSlider.setValue(70);
        soundVolumeSlider.setName("Sound");
        Label soundLabel = new Label("Sound Volume:", skin);
        soundLabel.setPosition((Gdx.graphics.getWidth()-soundVolumeSlider.getWidth())/2 - soundVolumeSlider.getWidth(), Gdx.graphics.getHeight()/2- 1.5f*musicVolumeSlider.getHeight());

        Button quitButton = new TextButton("BACK",skin);
        quitButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        quitButton.setPosition(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        quitButton.setName("Back");

        Button difficultyEasyButton = new TextButton("EASY", skin);
        Button difficultyNormalButton = new TextButton("NORMAL", skin);
        Button difficultyHardButton = new TextButton("HARD", skin);

        difficultyEasyButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        difficultyEasyButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10)/2 - Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/2+2*musicVolumeSlider.getHeight());
        difficultyEasyButton.setName("Easy");

        difficultyNormalButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        difficultyNormalButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10)/2,Gdx.graphics.getHeight()/2+2*musicVolumeSlider.getHeight());
        difficultyNormalButton.setName("Normal");

        difficultyHardButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        difficultyHardButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10)/2 + Gdx.graphics.getWidth()/10,(Gdx.graphics.getHeight()/2+2*musicVolumeSlider.getHeight()));
        difficultyHardButton.setName("Hard");

        settingsMenu.addActor(backgroundImage);
        settingsMenu.addActor(settingsText);
        settingsMenu.addActor(difficultyEasyButton);
        settingsMenu.addActor(difficultyNormalButton);
        settingsMenu.addActor(difficultyHardButton);
        settingsMenu.addActor(musicVolumeSlider);
        settingsMenu.addActor(musicLabel);
        settingsMenu.addActor(soundVolumeSlider);
        settingsMenu.addActor(soundLabel);
        settingsMenu.addActor(quitButton);
        return settingsMenu;
    }

    //public static Button createButton(String name, float x, float y, float width, float height, Skin skin, Color color){

}

