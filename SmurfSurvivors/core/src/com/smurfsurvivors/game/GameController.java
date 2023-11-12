package com.smurfsurvivors.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.PlayerCharacter;

import java.util.ArrayList;
import java.util.Arrays;

public class GameController implements Observer {

    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        controllerInit();
    }

    public void controllerInit() {
        observerInit();
    }

    private void getInput() {
        int inputUp = 0;
        int inputDown = 0;
        int inputRight = 0;
        int inputLeft = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            inputUp = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            inputDown = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            inputRight = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            inputLeft = 1;
        }
        model.updatePlayerPosition(new ArrayList<Integer>(Arrays.asList(inputUp, inputDown, inputRight, inputLeft)));
    }

    public void observerInit() {
        model.addObserver(this);
    }


    public void observerUpdate() {
        getInput();
    }

}
