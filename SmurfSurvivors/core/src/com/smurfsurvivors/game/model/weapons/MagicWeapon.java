package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MagicWeapon extends PassiveWeapon{
    private final Vector2 nearestEnemyPosition;
    public MagicWeapon(Vector2 _position, TextureRegion weaponTexture, Vector2 nearestEnemyPosition){
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
