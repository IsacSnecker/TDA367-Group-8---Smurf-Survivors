package com.smurfsurvivors.game;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.PlayerCharacter;

public abstract class GameModelFactory {

    public static GameModel createDefaultModel() {

        GameModel model = new GameModel();

        PlayerCharacter player = new PlayerCharacter(100, new Texture("Player/smurf-100x100.png"), 100,100, 100,100);
        model.setPlayer(player);

        Demon demon = new Demon(new Texture("Enemies/blueDemon.png"), 1000, 100, 64, 64);
        model.addEnemy(demon);

        return model;
    }

}
