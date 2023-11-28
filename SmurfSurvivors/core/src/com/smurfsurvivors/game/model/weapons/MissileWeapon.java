package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Enemy;

public class MissileWeapon extends PassiveWeapon{

    Enemy nearestEnemy;

    public MissileWeapon(Vector2 _position, TextureRegion weaponTexture, Enemy nearestEnemy){
        super(_position, weaponTexture, 50f,100f, 1200f, 10, 200, 0, "Missile");
        this.nearestEnemy = nearestEnemy;

    }

    void update(){
        moveTowardsPosition(nearestEnemy.getPosition());
    }

    public Enemy getEnemy(){
        return nearestEnemy;
    }

    @Override
    public void render(SpriteBatch batch){
        batch.draw(weaponTexture, position.x, position.y, width, height, width, height, 1,1, calculateRotation() - 90);
    }

    private float calculateRotation(){
        return (float) Math.toDegrees(Math.atan2(nearestEnemy.getY() - position.y, nearestEnemy.getX() - position.x));
    }
}
