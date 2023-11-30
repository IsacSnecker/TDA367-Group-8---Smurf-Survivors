package com.smurfsurvivors.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.smurfsurvivors.game.DifficultyFactory;
import com.smurfsurvivors.game.Observer;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.view.GameView;
import com.smurfsurvivors.game.view.PauseMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class GameController implements Observer {

    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        controllerInit();
        buttonsInit();
        //PauseMenu pause = new PauseMenu();
    }

    public void controllerInit() { observerInit();}

    private void getInput() {
        int inputUp = 0;
        int inputDown = 0;
        int inputRight = 0;
        int inputLeft = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            inputUp = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            inputDown = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
            inputRight = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            inputLeft = 1;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            if(!model.getIsPaused()){
                Gdx.input.setInputProcessor(view.pauseStage);
            }
            else{
                Gdx.input.setInputProcessor(null);
            }
            view.settingsMenu.open = false;
            model.togglePaused();
        }
        model.updatePlayerPosition(new ArrayList<Integer>(Arrays.asList(inputUp, inputRight, inputDown, inputLeft)));
    }

    public void observerInit() {
        model.addObserver(this);
    }

    public void buttonsInit() {
        Gdx.input.setInputProcessor(view.mainStage);
        this.view.pause.quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
        this.view.pause.settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.input.setInputProcessor(view.settingsStage);
                view.settingsMenu.open = true;
            }
        });
        this.view.pause.resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.input.setInputProcessor(null);
                model.togglePaused();
            }
        });
        this.view.settingsMenu.difficultyEasyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createEasyDifficulty());
                System.out.println(model.getDifficulty());
            }
        });
        this.view.settingsMenu.difficultyNormalButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createNormalDifficulty());
                System.out.println(model.getDifficulty());
            }
        });
        this.view.settingsMenu.difficultyHardButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createHardDifficulty());
                System.out.println(model.getDifficulty());
            }
        });
        this.view.settingsMenu.musicVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                model.setMusicVolume(view.settingsMenu.musicVolumeSlider.getValue()/100);
            }
        });
        this.view.settingsMenu.soundVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                model.setSoundEffectVolume(view.settingsMenu.soundVolumeSlider.getValue()/100);
            }
        });
        this.view.settingsMenu.quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
        this.view.mainMenu.quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
        this.view.mainMenu.settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.input.setInputProcessor(view.settingsStage);
                view.mainMenu.isOpen = false;
                view.settingsMenu.open = true;
            }
        });
        this.view.mainMenu.startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.input.setInputProcessor(null);
                view.mainMenu.isOpen = false;
                model.togglePaused();
            }
        });
    }


    public void observerUpdate() {
        getInput();
    }

}
