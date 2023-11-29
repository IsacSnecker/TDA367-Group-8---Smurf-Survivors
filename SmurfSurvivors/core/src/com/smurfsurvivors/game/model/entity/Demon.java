package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.AudioManager;

public class Demon extends Enemy{
    static Texture demonTexture = new Texture("Enemies/demon.png");
    public Demon(float x, float y) {
        super(100, 100, demonTexture, x, y, 128, 128, 1, 0, 10);

    }



}
