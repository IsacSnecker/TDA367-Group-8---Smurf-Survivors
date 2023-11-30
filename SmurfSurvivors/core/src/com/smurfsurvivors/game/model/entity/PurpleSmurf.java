package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;

public class PurpleSmurf extends Enemy{
    static Texture purpleSmurfTexture = new Texture("Enemies/demon.png");

    public PurpleSmurf(float x, float y) {
        super(100, 25, purpleSmurfTexture, x, y, 128, 128, 1, 0, 2);
    }



}
