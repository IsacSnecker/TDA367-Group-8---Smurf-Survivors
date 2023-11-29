package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl.audio.Wav;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Food extends Entity {

    private int health;

    private final Sound soundEffect = Gdx.audio.newSound(new FileHandle("Sounds/Music/SoundsFX/HealthPickUp.wav"));


    static Texture foodTexture = new Texture("Items/health.png");

    public Food(int health, int x, int y, int width, int height) {
        super(foodTexture, x, y,width, height);
        this.health = health;
        foodInit();
    }

    private void foodInit() {

    }

    public int getHealth() {
        return this.health;
    }

    public void render(Batch batch) {
        batch.draw(foodTexture, getX(), getY());
    }

    public Sound getSoundEffect() {
        return this.soundEffect;
    }

}
