package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Entity {

    private Texture sprite;
    private int x;
    private int y;
    private int width;
    private int height;

    public Texture getSprite() {
        return sprite;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

}
