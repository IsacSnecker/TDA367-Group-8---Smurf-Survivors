package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class HealthBar  {

    private int maxHealth;
    private int currentHealth;

    private Batch hudBatch;

    public HealthBar(int maxHealth, int currentHealth, Batch hudBatch) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.hudBatch = hudBatch;
    }


    public void render() {
        hudBatch.draw(new Texture("UI/barEmpty.png"), 0, 0, maxHealth * 2, 40);
        hudBatch.draw(new Texture("UI/healthBarFull.png"), 0, 0, currentHealth * 2, 40);
    }


}
