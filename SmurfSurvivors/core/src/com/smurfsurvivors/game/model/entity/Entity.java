package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
        position = new Vector2(x,y);
        this.width = width;
        this.height = height;
        entityInit();
    }

    private void entityInit() {
        this.sprite = new Sprite(texture, 0, 0, width, height);
        sprite.scale(100);
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
    public float getY(){ return position.y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void setX(float x) {  position.x = x; }
    public void setY(float y) { position.y = y; }

    public void render(Batch batch) {
        //batch.draw(this.texture, position.x - getWidth() / 2, position.y - getHeight() / 2);

        //batch.draw(this.texture, this.position.x, this.position.y,
        //this.width, this.height, 0, 0, 100, 100);

        batch.draw(this.texture, this.position.x, this.position.y,
                this.width, this.height);

        //int srcWidth, int srcHeight, boolean flipX, boolean flipY)

    }

    public Rectangle getRectangle(){
        return new Rectangle(position.x, position.y, width, height);
    }

    public Vector2 getPosition(){
        return position;
    }

}
