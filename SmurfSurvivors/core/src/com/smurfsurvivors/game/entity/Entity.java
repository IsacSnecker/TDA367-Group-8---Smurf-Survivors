package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Entity {
    private Texture texture; //Should probably not be final

    private Sprite sprite;

    private int x;
    private int y;
    private final int width; //should width be final?
    private final int height; //should height be final?

    public Entity(Texture sprite, int x, int y, int width, int height) {
        this.texture = sprite;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        entityInit();
    }

    private void entityInit() {
        this.sprite = new Sprite(texture, 0, 0, width, height);
    }

    public Texture getTexture() {
        return texture;
    }
    public void setTexture(Texture texture){ this.texture  = texture; }
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
        this.sprite = new Sprite(texture, 0, 0, width, height);
        batch.draw(this.sprite, x - getWidth() / 2, y - getHeight() / 2);
    }

}
