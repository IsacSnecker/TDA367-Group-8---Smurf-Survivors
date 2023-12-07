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
            if(model.getIsOpen(model.getPauseMenu())){
                Gdx.input.setInputProcessor(null);
                model.switchMenu(null);
                model.togglePaused();
            }
            else if (Gdx.input.getInputProcessor() == null){
                Gdx.input.setInputProcessor(model.getPauseMenu());
                model.switchMenu(model.getPauseMenu());
                model.togglePaused();
            }/*
            if(model.getIsOpen(model.getMainMenu()) || model.getIsOpen(model.getSettingsMenu())){
                return;
            }
            if(!model.getIsPaused()){
                Gdx.input.setInputProcessor(model.getPauseMenu());
                model.switchMenu(model.getPauseMenu());
                //model.setIsOpen(model.getPauseMenu(),true);
            }
            else{
                Gdx.input.setInputProcessor(null);
            }
            //model.setIsOpen(model.getSettingsMenu(), false);
            model.switchMenu(model.getSettingsMenu());*/

        }
        model.updatePlayerPosition(new ArrayList<Integer>(Arrays.asList(inputUp, inputRight, inputDown, inputLeft)));
    }

    public void observerInit() {
        model.addObserver(this);
    }

    private void buttonsInit() {
        Gdx.input.setInputProcessor(model.getMainMenu());
        this.model.getActor(model.getPauseMenu(), "Quit").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
        this.model.getActor(model.getPauseMenu(),"Settings").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.input.setInputProcessor(model.getSettingsMenu());
                //model.setIsOpen(model.getSettingsMenu(), true);
                model.switchMenu(model.getSettingsMenu());
            }
        });
        this.model.getActor(model.getPauseMenu(), "Resume").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.input.setInputProcessor(null);
                model.switchMenu(null);
                model.togglePaused();
            }
        });

        this.model.getActor(model.getSettingsMenu(), "Easy").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createEasyDifficulty());
                //System.out.println(model.getDifficulty().getEnemyHealthMultiplier());
            }
        });
        this.model.getActor(model.getSettingsMenu(), "Normal").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createNormalDifficulty());
                //System.out.println(model.getDifficulty().getEnemyHealthMultiplier());
            }
        });
        this.model.getActor(model.getSettingsMenu(), "Hard").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.setDifficulty(DifficultyFactory.createHardDifficulty());
                //System.out.println(model.getDifficulty().getEnemyHealthMultiplier());
            }
        });
        this.model.getActor(model.getSettingsMenu(), "Music").addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //view.((Slider)model.getActor(model.getSettingsMenu(), "Music")).getValue()/100
            }
        });
        this.model.getActor(model.getSettingsMenu(), "Sound").addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //view.((Slider)model.getActor(model.getSettingsMenu(), "Sound")).getValue()/100
            }
        });
        this.model.getActor(model.getSettingsMenu(), "Back").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //model.setIsOpen(model.getSettingsMenu(), false);
                if(model.getIsOpen(model.getPauseMenu())){
                    Gdx.input.setInputProcessor(model.getPauseMenu());
                    model.switchMenu(model.getPauseMenu());
                }
                else {
                    Gdx.input.setInputProcessor(model.getMainMenu());
                    model.switchMenu(model.getMainMenu());
                    //model.setIsOpen(model.getMainMenu(), true);
                }

            }
        });
        this.model.getActor(model.getMainMenu(), "Quit").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
        this.model.getActor(model.getMainMenu(), "Settings").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.input.setInputProcessor(model.getSettingsMenu());
                //model.setIsOpen(model.getMainMenu(), false);
                model.switchMenu(model.getSettingsMenu());
                //model.setIsOpen(model.getSettingsMenu(), true);
            }
        });
        this.model.getActor(model.getMainMenu(), "Start").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.input.setInputProcessor(null);
                //model.setIsOpen(model.getMainMenu(), false);
                model.switchMenu(null);
                model.togglePaused();
            }
        });
    }


    public void observerUpdate() {
        getInput();
    }

}
