package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private Texture texture; //Should probably not be final
    private Sprite sprite;
    private Vector2 position;
    private final int width; //should width be final?
    private final int height; //should height be final?

    public Entity(Texture sprite, float x, float y, int width, int height) {
        this.texture = sprite;
        this.sprite = new Sprite(texture, 0, 0, width, height);
        position = new Vector2(x,y);
        this.width = width;
        this.height = height;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getX() {
        return position.x;
    }
    public float getY(){ return position.y;}
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void setX(float x) {  position.x = x; }
    public void setY(float y) { position.y = y; }

    public void render(Batch batch) {
        sprite.setPosition(this.position.x, this.position.y);
        batch.setColor(1,1,1,1);
        sprite.draw(batch);

    }
    public void showHit(){
        sprite.setColor(1,0,0,1);

    }
    public Rectangle getRectangle(){
        return new Rectangle(position.x, position.y, width, height);
    }

    public Vector2 getPosition(){
        return position;
    }

    public Sprite getSprite(){
        return sprite;
    }

}
