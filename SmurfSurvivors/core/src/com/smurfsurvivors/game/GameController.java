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

public class GameController extends ApplicationAdapter {

    private GameModel model;

    public GameController(GameModel _model) {
        this.model = _model;
    }

    @Override
    public void create () {
        model.init();
    }

    @Override
    public void render () {
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
        model.update(new ArrayList<Integer>(Arrays.asList(inputUp, inputDown, inputRight, inputLeft)));
    }

}
