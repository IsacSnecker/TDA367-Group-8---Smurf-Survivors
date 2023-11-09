package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import javax.crypto.spec.OAEPParameterSpec;
import java.nio.file.Path;

public abstract class Entity {
    //private Texture sprite; //Should probably not be final
    private Texture sprite;
    private int x;
    private int y;
    private final int width; //should width be final?
    private final int height; //should height be final?

    public Entity(Texture sprite, int x, int y, int width, int height) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    /*public Texture getSprite() {
        return sprite;
    }*/

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

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void render(Batch batch) {
        batch.draw(this.sprite, this.x - getWidth() / 2, this.y - getHeight() / 2);
    }

}
