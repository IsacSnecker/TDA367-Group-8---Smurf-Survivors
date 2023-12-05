package com.smurfsurvivors.game;

import com.badlogic.gdx.Game;
import com.smurfsurvivors.game.controller.GameController;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.GameModelFactory;
import com.smurfsurvivors.game.view.GameView;

public class SmurfSurvivors extends Game {

    GameModel gameModel;
    GameController gameController;
    GameView gameView;


    @Override
    public void create() {

        // MVC initialization
        gameModel = GameModelFactory.createNormalModel();
        gameView = new GameView(gameModel);
        gameController = new GameController(gameModel, gameView);

    }

    @Override
    public void render() {

        gameModel.update();

        if(gameModel.getIsGameOver()){
            create();
        }
    }
    @Override
    public void dispose() {
        gameView.dispose();
    }

}
