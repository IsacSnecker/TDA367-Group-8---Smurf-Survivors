package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class MagicWeapon extends PassiveWeapon{
    private final Vector2 nearestEnemyPosition;
    public MagicWeapon(Vector2 _position, Texture weaponTexture, Vector2 nearestEnemyPosition){
        super(_position, weaponTexture, 100, 100, 5000f, 20,70,"Magic");
        this.nearestEnemyPosition = nearestEnemyPosition;
    }
    public void update(){
        moveTowardsPosition(nearestEnemyPosition);
    }

    public Vector2 getEnemyPosition(){
        return nearestEnemyPosition;
    }
}
