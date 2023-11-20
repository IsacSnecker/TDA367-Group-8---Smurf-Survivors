package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MissileWeapon extends PassiveWeapon{

    public MissileWeapon(Vector2 _position){
        super(_position, new Texture("Weapons/missile.png"), 50f,100f, 1500f, 20, 200, "Missile");
    }

    void update(Vector2 enemyPosition) {
        moveTowardsPosition(enemyPosition);
    }
}
