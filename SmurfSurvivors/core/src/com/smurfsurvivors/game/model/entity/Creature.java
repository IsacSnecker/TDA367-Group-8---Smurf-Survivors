package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Creature extends Entity implements HasHealth, Movable{
    private int health;

    private int maxHealth;
    private int direction;
    private float speed;
    private boolean isHurt = false;

    public Creature(int health, Texture sprite, float x, float y, int width, int height, float speed, int direction) {
        super(sprite, x, y, width, height);
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.direction = direction;

    }

    public int getHealth(){
        return health;
    }

    public void addHealth(int amount) {

        this.health += amount;

        if (health > maxHealth) this.health = maxHealth;

    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void increaseHealth(int amount) { health += amount; }
    public void decreaseHealth(int amount){
        health -= amount;
        isHurt = true;
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
    public boolean getIsHurt() {
        return isHurt;
    }
    public void setHurt(boolean hurt) {
        isHurt = hurt;
    }
    //public abstract void performAttack();

}