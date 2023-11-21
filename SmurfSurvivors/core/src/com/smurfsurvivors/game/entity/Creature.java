package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Creature extends Entity implements HasHealth, Movable{
    private int health;
    private int direction;
    private float speed;
    public Creature(int health, Texture sprite, float x, float y, int width, int height, float speed, int direction) {
        super(sprite, x, y, width, height);
        this.health = health;
        this.speed = speed;
        this.direction = direction;

    }

    public int getHealth(){
        return health;
    }
    public void decreaseHealth(int amount){
        health -= amount;
    }

    public int getDirection(){
        return direction;
    }

    public void setDirection(int direction){ this.direction = direction; }
    public float getSpeed(){ return speed; }
    public void move(float dx, float dy){
        setX(getX() + dx);
        setY(getY() + dy);
    }
    //public abstract void performAttack();
}