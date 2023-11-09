package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Enemy extends Creature{

    public Enemy(Texture sprite, int x, int y, int width, int height) {
        super(sprite, x, y, width, height);
    }
    public void moveTowardsEntity(Entity entity){
        if(entity.getX() < getX()){
            move(-10, 0);
        }
        else if(entity.getX() > getX()){
            move(10, 0);
        }
        //move()
    }
}
