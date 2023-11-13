package com.smurfsurvivors.game.weapons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.Entity;

public class KnifeWeapon extends PassiveWeapon{

    float velocity;
    public KnifeWeapon(Vector2 _position){
        super(_position, new Texture("Weapons/Knife.png"), 50f,50f, 500f, 10, "Knife");
        velocity = 20f;

    }

    public void update(){

    }

    public void render(SpriteBatch batch){
        batch.draw(weaponTexture, position.x, position.y, width, height);
    }

}
