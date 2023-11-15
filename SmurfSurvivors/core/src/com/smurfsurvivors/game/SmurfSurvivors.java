package com.smurfsurvivors.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SmurfSurvivors extends Game {

    GameModel gameModel;
    GameController gameController;
    GameView gameView;


    @Override
    public void create() {

        // MVC initialization
        gameModel = GameModelFactory.createDefaultModel();
        gameView = new GameView(gameModel);
        gameController = new GameController(gameModel, gameView);

    }

    @Override
    public void render() {
        gameModel.update();
    }
    @Override
    public void dispose() {
        gameView.dispose();
    }

}
