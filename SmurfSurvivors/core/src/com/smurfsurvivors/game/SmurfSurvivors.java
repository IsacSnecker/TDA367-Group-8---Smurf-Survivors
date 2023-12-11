package com.smurfsurvivors.game;

import com.badlogic.gdx.Game;
import com.smurfsurvivors.game.controller.GameController;
import com.smurfsurvivors.game.controller.IGameController;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.GameModelFactory;
import com.smurfsurvivors.game.view.GameView;
import com.smurfsurvivors.game.view.IGameView;

public class SmurfSurvivors extends Game {

    GameModel gameModel;


    @Override
    public void create() {

        // MVC initialization
         this.gameModel = GameModelFactory.createNormalModel();
        IGameView gameView = new GameView(gameModel);
        IGameController gameController = new GameController(gameModel, gameView);

    }

    @Override
    public void render() {

        gameModel.update();

        if(gameModel.getIsGameOver()){
            System.exit(0);
            //create();
        }
    }
    @Override
    public void dispose() {

    }

}
