package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;

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

        if(differenceX > 0 && differenceY > 0){
            calculateDirectionAndMove(differenceX, differenceY, 1, 1);
        }
        else if(differenceX > 0 && differenceY < 0){
            calculateDirectionAndMove(differenceX, differenceY, 1, -1);
        }
        else if(differenceX < 0 && differenceY > 0){
            calculateDirectionAndMove(differenceX, differenceY, -1, 1);
        }
        else if(differenceX < 0 && differenceY < 0){
            calculateDirectionAndMove(differenceX, differenceY, -1, -1);
        }
    }

    private void calculateDirectionAndMove(float differenceX, float differenceY, int signX, int signY){
        float radianDegree = calculateRadianDegree(signX*differenceX, signY*differenceY);
        float dx = calculatedx(radianDegree);
        float dy = calculatedy(radianDegree);
        move(signX*dx, signY*dy);
    }

    private float calculateRadianDegree(float differenceX, float differenceY){ return (float)Math.atan(differenceX/differenceY); }

    private float calculatedx(float radianDegree){
        return (float)(Math.sin(radianDegree)*getSpeed());
    }

    private float calculatedy(float radianDegree){ return (float)(Math.cos(radianDegree)*getSpeed()); }

    public void damageEntity(HasHealth entity){
        entity.decreaseHealth(attackPower);
    }

}