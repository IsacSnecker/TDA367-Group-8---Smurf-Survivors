package com.smurfsurvivors.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SmurfSurvivors extends ApplicationAdapter {

    GameModel gameModel;
    GameController gameController;

    GameView gameView;


    @Override
    public void create() {

        // MVC initialization
        gameModel = GameModelFactory.createDefaultModel();
        gameController = new GameController(gameModel);
        gameView = new GameView(gameModel, gameController);

    }

    @Override
    public void render() {
        gameModel.update();
    }
    @Override
    public void dispose() {

    }

}
