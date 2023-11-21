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
        float dx;
        float dy;
        float radianDegree;
        if(differenceX > 0 && differenceY > 0){
            radianDegree = calculateRadianDegree(differenceX, differenceY);
            dx = calculatedx(radianDegree);
            dy = calculatedy(radianDegree);
            move(dx, dy);
        }
        else if(differenceX > 0 && differenceY < 0){
            radianDegree = calculateRadianDegree(differenceX, -differenceY);
            dx = calculatedx(radianDegree);
            dy = calculatedy(radianDegree);
            move(dx, -dy);
        }
        else if(differenceX < 0 && differenceY > 0){
            radianDegree = calculateRadianDegree(-differenceX, differenceY);
            dx = calculatedx(radianDegree);
            dy = calculatedy(radianDegree);
            move(-dx, dy);
        }
        else if(differenceX < 0 && differenceY < 0){
            radianDegree = calculateRadianDegree(-differenceX, -differenceY);
            dx = calculatedx(radianDegree);
            dy = calculatedy(radianDegree);
            move(-dx, -dy);
        }
    }

    private float calculateRadianDegree(float differenceX, float differenceY){
        return (float)Math.atan(differenceX/differenceY);
    }

    private float calculatedx(float radianDegree){
        return (float)(Math.sin(radianDegree)*getSpeed());
    }

    private float calculatedy(float radianDegree){
        return (float)(Math.cos(radianDegree)*getSpeed());
    }

    public void damageEntity(HasHealth entity){
        entity.decreaseHealth(attackPower);
    }

}