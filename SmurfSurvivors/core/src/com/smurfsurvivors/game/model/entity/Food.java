package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl.audio.Wav;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Food extends Entity {

    private int health;


    public Food(int health, int x, int y, int width, int height) {
        super("Food", x, y,width, height);
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }


}
