package com.smurfsurvivors.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.smurfsurvivors.game.model.factories.DifficultyFactory;
import com.smurfsurvivors.game.Observer;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.view.GameView;
import com.smurfsurvivors.game.view.IGameView;

import java.util.ArrayList;
import java.util.Arrays;

public class GameController implements IGameController {

    private GameModel model;
    private IGameView view;

    public GameController(GameModel model, IGameView view) {
        this.model = model;
        this.view = view;
        controllerInit();
        buttonsInit();
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
            model.setIsPaused(true);
            model.switchMenu("Pause");
        }
        model.updatePlayerPosition(new ArrayList<Integer>(Arrays.asList(inputUp, inputRight, inputDown, inputLeft)));
    }

    public void observerInit() {
        model.addObserver(this);
    }

    private void buttonsInit() {
        Gdx.input.setInputProcessor(model.getMenu("Main"));
        this.model.getActor(model.getMenu("Pause"), "Quit").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
        this.model.getActor(model.getMenu("Pause"),"Settings").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                model.switchMenu("Settings");
            }
        });
        this.model.getActor(model.getMenu("Pause"), "Resume").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.switchMenu("");
                model.setIsPaused(false);
            }
        });

        this.model.getActor(model.getMenu("Settings"), "Easy").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createEasyDifficulty());
            }
        });
        this.model.getActor(model.getMenu("Settings"), "Normal").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createNormalDifficulty());
            }
        });
        this.model.getActor(model.getMenu("Settings"), "Hard").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createHardDifficulty());
            }
        });
        this.model.getActor(model.getMenu("Settings"), "Music").addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                view.getAudioManager().setMusicVolume(((Slider)model.getActor(model.getMenu("Settings"), "Music")).getValue()/100);
            }
        });
        this.model.getActor(model.getMenu("Settings"), "Sound").addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                view.getAudioManager().setSoundVolume(((Slider)model.getActor(model.getMenu("Settings"), "Sound")).getValue()/100);
            }
        });
        this.model.getActor(model.getMenu("Settings"), "Back").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.closeMenu();
            }
        });
        this.model.getActor(model.getMenu("Main"), "Quit").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
        this.model.getActor(model.getMenu("Main"), "Settings").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                model.switchMenu("Settings");
            }
        });
        this.model.getActor(model.getMenu("Main"), "Start").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.switchMenu("");
                model.setIsPaused(false);
            }
        });
    }


    public void observerUpdate() {
        getInput();
    }

}
