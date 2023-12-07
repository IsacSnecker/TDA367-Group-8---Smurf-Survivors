package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class HealthBar  {

    private int maxHealth;
    private Batch hudBatch;
    private Texture barEmptyTexture;
    private Texture healthBarFullTexture;
    private int width;
    private int height;
    BitmapFont font = new BitmapFont();


    public HealthBar(int maxHealth, int currentHealth, Batch hudBatch) {
        this.maxHealth = maxHealth;
        this.hudBatch = hudBatch;
        this.barEmptyTexture = new Texture("UI/barEmpty.png");
        this.healthBarFullTexture = new Texture("UI/healthBarFull.png");
        this.width = 400;
        this.height = 50;
        font.getData().setScale(2);
    }


    public void render(int currentHealth) {
        hudBatch.draw(barEmptyTexture, 0, 0, width, height);
        hudBatch.draw(healthBarFullTexture, 0, 0, (int)((float)currentHealth * ((float)width/(float)maxHealth)), height);
        font.draw(hudBatch, "Health: " + currentHealth, width-160, 35);
    }
}
