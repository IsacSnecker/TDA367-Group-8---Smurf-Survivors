package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;

public class Nemesis extends Enemy{

    static Texture nemesisTexture = new Texture("Enemies/demon.png");

    public Nemesis(float x, float y) {
        super(100, 300, nemesisTexture, x, y, 128, 128, 1, 0, 30);
    }


}
