package com.smurfsurvivors.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.Difficulty;
import com.smurfsurvivors.game.FoodHandler;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

public abstract class GameModelFactory {

    public static GameModel createDefaultModel() {

        GameModel model = new GameModel(new Difficulty(1.25, 1, 1));

        PlayerCharacter player = new PlayerCharacter(100, new Texture("Player/smurf-100x100.png"), 16000,16000, 100,100, 7, 0);
        model.setPlayer(player);

        return model;
    }
}
