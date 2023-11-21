package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class HealthBar  {

    private int maxHealth;
    private int currentHealth;
    private Batch hudBatch;
    private Texture barEmptyTexture;
    private Texture healthBarFullTexture;

    public HealthBar(int maxHealth, int currentHealth, Batch hudBatch) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.hudBatch = hudBatch;
        this.barEmptyTexture = new Texture("UI/barEmpty.png");
        this.healthBarFullTexture = new Texture("UI/healthBarFull.png");
    }


    public void render() {
        hudBatch.draw(barEmptyTexture, 0, 0, maxHealth * 2, 40);
        hudBatch.draw(healthBarFullTexture, 0, 0, currentHealth * 2, 40);
    }


}
