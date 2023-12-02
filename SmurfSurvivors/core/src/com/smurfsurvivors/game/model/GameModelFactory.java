package com.smurfsurvivors.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.*;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

public abstract class GameModelFactory {

    public static GameModel createDefaultModel() {

        GameModel model = new GameModel(DifficultyFactory.createNormalDifficulty());

        //model.setMusicVolume(0.2f);
        //model.setSoundEffectVolume(0.7f);

        PlayerCharacter player = new PlayerCharacter(100, 16000,16000, 100,100, 7, 0);

        model.init(player);
        return model;
    }
}
