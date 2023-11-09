package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Creature extends Entity implements HasHealth, Movable{
    private int health;

    public Creature(Texture sprite, int x, int y, int width, int height) {
        super(sprite, x, y, width, height);
    }

    public int getHealth(){
        return health;
    }
    public void decreaseHealth(int amount){
        health -= amount;
    }
    public void move(int dx, int dy){
        setX(getX() + dx);
        setY(getY() + dy);
    }
    //public abstract void performAttack();
}
