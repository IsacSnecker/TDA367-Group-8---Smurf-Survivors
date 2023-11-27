package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Enemy;

public class MissileWeapon extends PassiveWeapon{

    Enemy nearestEnemy;

    public MissileWeapon(Vector2 _position, TextureRegion weaponTexture, Enemy nearestEnemy){
        super(_position, weaponTexture, 50f,100f, 1200f, 20, 200, "Missile");
        this.nearestEnemy = nearestEnemy;

    }

    void update(){
        moveTowardsPosition(nearestEnemy.getPosition());
    }

    public Enemy getEnemy(){
        return nearestEnemy;
    }
}
