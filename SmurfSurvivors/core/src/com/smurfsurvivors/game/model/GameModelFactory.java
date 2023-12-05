package com.smurfsurvivors.game.model;

import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import com.smurfsurvivors.game.model.factories.DifficultyFactory;

public abstract class GameModelFactory {

    public static GameModel createDefaultModel() {

        GameModel model = new GameModel(DifficultyFactory.createNormalDifficulty());

        //model.setMusicVolume(0.2f);
        //model.setSoundEffectVolume(0.7f);

        PlayerCharacter player = new PlayerCharacter(100, 16000,16000, 90,90, 5, 0);

        model.init(player);
        return model;
    }
}
