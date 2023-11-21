package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

import java.nio.file.Path;

public abstract class Enemy extends Creature{
    private int attackPower;
    private float speed;

    public Enemy(int attackPower, int health, Texture sprite, float x, float y, int width, int height, float speed, int direction) {
        super(health, sprite, x, y, width, height, speed, direction);
        this.attackPower = attackPower;
        this.speed = speed;
    }

    public void moveTowardsEntity(Entity entity){
        float differenceX = entity.getX() - getX();
        float differenceY = entity.getY() - getY();
        float dx = 0;
        float dy = 0;
        float radianDegree;
        if(differenceX > 0 && differenceY > 0){
            radianDegree = (float)Math.atan(differenceY/differenceX);
            System.out.println(getSpeed());
            dx = (float)(Math.tan(radianDegree)*getSpeed());
            dy = (float)(getSpeed()/Math.tan(radianDegree));
            move(dx, dy);
            System.out.println(dx);
            System.out.println(dy);
        }

        /*if(entity.getX() < getX() && entity.getY() < getY()){
            move(-speed, -speed);
        }
        else if(entity.getX() < getX() && entity.getY() > getY()){
            move(-speed, speed);
        }
        else if(entity.getX() > getX() && entity.getY() < getY()){
            move(speed, -speed);
        }
        else if(entity.getX() > getX() && entity.getY() > getY()) {
            move(speed, speed);
        }
        else if(entity.getX() > getX()){
            move(speed, 0);
        }
        else if(entity.getY() > getY()){
            move(0, speed);
        }
        else if(entity.getX() < getX()){
            move(-speed, 0);
        }
        else if(entity.getY() < getY()){
            move(0, -speed);
        }*/
    }

    public void damageEntity(HasHealth entity){
        entity.decreaseHealth(attackPower);
    }

}