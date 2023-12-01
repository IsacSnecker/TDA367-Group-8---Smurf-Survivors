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

    private String name;
    private Vector2 position;

    private boolean lookingRight = true;
    private final int width; //should width be final?
    private final int height; //should height be final?

    public Entity(String name, float x, float y, int width, int height) {
        position = new Vector2(x,y);
        this.width = width;
        this.height = height;
        this.name = name;
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


    public void showHit(){
       // sprite.setColor(1,0,0,1);
    }
    public Rectangle getRectangle(){
        return new Rectangle(position.x, position.y, width, height);
    }

    public Vector2 getPosition(){
        return position;
    }


    public String getName() { return name; }

    public boolean isLookingRight() {
        return lookingRight;
    }

    public void setLookingRight(boolean val) {
        lookingRight = val;
    }
}
