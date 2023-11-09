package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Demon extends Enemy{
    public Demon(Texture sprite, int x, int y, int width, int height) {
        super(sprite, x, y, width, height);
    }

    public void performAttack(){

    }
}
