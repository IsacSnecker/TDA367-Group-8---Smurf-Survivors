package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Entity {
    private Texture sprite;
    private int x;
    private int y;
    private int width;
    private int height;

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
