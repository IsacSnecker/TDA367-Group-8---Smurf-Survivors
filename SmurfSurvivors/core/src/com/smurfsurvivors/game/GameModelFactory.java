package com.smurfsurvivors.game;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.PlayerCharacter;

public abstract class GameModelFactory {

    public static IGameModel createDefaultModel() {

        IGameModel model = new GameModel();

        //PlayerCharacter player = new PlayerCharacter(new Texture("Player/smurf.png"), 0,0, 32,32);
        //model.setPlayer(player);

        //Demon demon = new Demon(new Texture("Enemies/blueDemon.png"), 0, 0, 32, 32);
        //model.addEnemy(demon);

        return model;
    }

}
