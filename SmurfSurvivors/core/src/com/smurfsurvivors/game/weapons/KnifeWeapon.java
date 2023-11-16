package com.smurfsurvivors.game.weapons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.Entity;

public class KnifeWeapon extends PassiveWeapon{

    public KnifeWeapon(Vector2 _position){
        super(_position, new Texture("Weapons/knife.png"), 50f,50f, 500f, 12, 50, "Knife");

    }

    public void update(Vector2 enemyPosition){
        move(velocity,0);
    }

}
