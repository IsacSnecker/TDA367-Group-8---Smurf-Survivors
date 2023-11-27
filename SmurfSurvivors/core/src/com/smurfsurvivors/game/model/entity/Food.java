package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Food extends Entity {

    private int health;

    static Texture foodTexture = new Texture("Items/health.png");

    public Food(int health, int x, int y, int width, int height) {
        super(foodTexture, x, y,width, height);
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void render(Batch batch) {
        batch.draw(foodTexture, getX(), getY());
    }

}
