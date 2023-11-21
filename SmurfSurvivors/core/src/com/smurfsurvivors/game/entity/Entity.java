package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
    private Texture texture; //Should probably not be final

    private Sprite sprite;

    private Vector2 position;
    private final int width; //should width be final?
    private final int height; //should height be final?

    public Entity(Texture sprite, int x, int y, int width, int height) {
        this.texture = sprite;
        position = new Vector2(x,y);
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

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getX() {
        return (int)position.x;
    }
    public int getY(){ return (int)position.y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void setX(int x) {  position.x = x; }
    public void setY(int y) { position.y = y; }

    public void render(Batch batch) {
        batch.draw(this.texture, position.x - getWidth() / 2, position.y - getHeight() / 2);
    }

    public Rectangle getRectangle(){
        return new Rectangle(position.x, position.y, width, height);
    }

    public Vector2 getPosition(){
        return position;
    }

}
