package com.smurfsurvivors.game.weapons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class KnifeWeapon extends PassiveWeapon{

    public KnifeWeapon(Vector2 _position, Texture weaponTexture){
        super(_position, weaponTexture, 50f,50f, 500f, 20, 50, "Knife");

    }

    public void update(Vector2 enemyPosition){
        move(velocity,0);
    }

}
