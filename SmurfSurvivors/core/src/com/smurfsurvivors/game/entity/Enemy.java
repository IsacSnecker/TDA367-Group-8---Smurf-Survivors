package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

import java.nio.file.Path;

public class Enemy extends Creature{
    private int attackPower;
    private int speed;

    public Enemy(int attackPower, int health, Texture sprite, int x, int y, int width, int height, int speed) {
        super(health, sprite, x, y, width, height, speed);
        this.attackPower = attackPower;
        this.speed = speed;
    }
    public void moveTowardsEntity(Entity entity){
        if(entity.getX() < getX() && entity.getY() < getY()){
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
        }
    }

    public void damageEntity(HasHealth entity){
        entity.decreaseHealth(attackPower);
    }

}
