package com.smurfsurvivors.game.model;

import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import com.smurfsurvivors.game.model.factories.DifficultyFactory;

public abstract class GameModelFactory {


    public static GameModel createEasyModel() {
        GameModel model = new GameModel(DifficultyFactory.createEasyDifficulty());

        return model;
    }

    public static GameModel createNormalModel() {
        GameModel model = new GameModel(DifficultyFactory.createNormalDifficulty());

        return model;
    }

    public static GameModel createHardModel() {
        GameModel model = new GameModel(DifficultyFactory.createHardDifficulty());

        return model;
    }

}
