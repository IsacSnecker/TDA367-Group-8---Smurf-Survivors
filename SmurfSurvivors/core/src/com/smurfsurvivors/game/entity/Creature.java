package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Creature extends Entity implements HasHealth, Movable{
    private int health;
    private int speed;
    public Creature(int health, Texture sprite, int x, int y, int width, int height, int speed) {
        super(sprite, x, y, width, height);
        this.health = health;
        this.speed = speed;
    }

    public int getHealth(){
        return health;
    }
    public void decreaseHealth(int amount){
        health -= amount;
    }
    public int getSpeed(){ return speed; }
    public void move(int dx, int dy){
        setX(getX() + dx);
        setY(getY() + dy);
    }
    //public abstract void performAttack();
}