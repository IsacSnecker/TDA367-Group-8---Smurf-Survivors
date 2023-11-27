package com.smurfsurvivors.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
            model.togglePaused();
        }
        model.updatePlayerPosition(new ArrayList<Integer>(Arrays.asList(inputUp, inputRight, inputDown, inputLeft)));
    }

    public void observerInit() {
        model.addObserver(this);
    }


    public void observerUpdate() {
        getInput();
    }

}
