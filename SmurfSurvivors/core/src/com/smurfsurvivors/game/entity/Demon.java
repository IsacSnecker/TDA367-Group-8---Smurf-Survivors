package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

import java.nio.file.Path;

public class Demon extends Enemy{
    static Texture demonTexture = new Texture("Enemies/blueDemon.png");
    public Demon(float x, float y) {
        super(100, 100, demonTexture, x, y, 64, 64, 1, 0);
    }

    public void performAttack(){

    }
}
