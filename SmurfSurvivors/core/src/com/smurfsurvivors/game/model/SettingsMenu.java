package com.smurfsurvivors.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class SettingsMenu {
    /*private Stage settingsStage;
    private Image backgroundImage;

    public Button difficultyEasyButton;
    public Button difficultyNormalButton;
    public Button difficultyHardButton;
    public ButtonGroup<Button> difficultyButtonGroup;
    public Slider musicVolumeSlider;
    public Slider soundVolumeSlider;
    public Button quitButton;
    public Boolean open = false;



    public SettingsMenu(Stage stage){
        this.settingsStage = stage;
        Group group = new Group();
        Skin skin = new Skin(Gdx.files.internal("Skins/skin/uiskin.json"));
        difficultyEasyButton = new TextButton("EASY", skin);
        difficultyEasyButton.setN
        difficultyNormalButton = new TextButton("NORMAL", skin);
        difficultyHardButton = new TextButton("HARD", skin);
        difficultyButtonGroup = new ButtonGroup<>(difficultyEasyButton, difficultyNormalButton, difficultyHardButton);
        difficultyButtonGroup.setMaxCheckCount(1);
        difficultyButtonGroup.setMinCheckCount(1);
        difficultyButtonGroup.setUncheckLast(true);
        difficultyButtonGroup.setChecked("NORMAL");
        System.out.println(difficultyButtonGroup.getChecked());
        difficultyEasyButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        difficultyEasyButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10)/2 - Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        difficultyNormalButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        difficultyNormalButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10)/2,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        difficultyHardButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        difficultyHardButton.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/10)/2 + Gdx.graphics.getWidth()/10,(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10));
        Texture backgroundTexture = new Texture("BackgroundTextures/smurfarna.png");
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        musicVolumeSlider = new Slider(0, 100, 1, false, skin);
        musicVolumeSlider.setPosition((Gdx.graphics.getWidth()-musicVolumeSlider.getWidth())/2, (Gdx.graphics.getHeight()- musicVolumeSlider.getHeight())/2);
        musicVolumeSlider.setValue(70);
        soundVolumeSlider = new Slider(0, 100, 1, false, skin);
        soundVolumeSlider.setPosition((Gdx.graphics.getWidth()-soundVolumeSlider.getWidth())/2, (Gdx.graphics.getHeight()/2- soundVolumeSlider.getHeight()));
        soundVolumeSlider.setValue(70);
        quitButton = new TextButton("QUIT",skin);
        quitButton.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        quitButton.setPosition(0,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/10);
        settingsStage.addActor(backgroundImage);
        settingsStage.addActor(difficultyEasyButton);
        settingsStage.addActor(difficultyNormalButton);
        settingsStage.addActor(difficultyHardButton);
        settingsStage.addActor(musicVolumeSlider);
        settingsStage.addActor(soundVolumeSlider);
        settingsStage.addActor(quitButton);
    }


    public void render(){
        settingsStage.draw();
    }*/
}
