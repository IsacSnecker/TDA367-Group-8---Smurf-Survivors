package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

import java.nio.file.Path;

public class Enemy extends Creature{
    private int attackPower;
    public Enemy(int attackPower, int health, Texture sprite, int x, int y, int width, int height) {
        super(health, sprite, x, y, width, height);
        this.attackPower = attackPower;
    }
    public void moveTowardsEntity(Entity entity){
        if(entity.getX() < getX() && entity.getY() < getY()){
            move(-10, -10);
        }
        else if(entity.getX() < getX() && entity.getY() > getY()){
            move(-10, 10);
        }
        else if(entity.getX() > getX() && entity.getY() < getY()){
            move(10, -10);
        }
        else if(entity.getX() > getX() && entity.getY() > getY()) {
            move(10, 10);
        }
    }

    public void damageEntity(HasHealth entity, int damage){
        entity.decreaseHealth(damage);
    }

}
