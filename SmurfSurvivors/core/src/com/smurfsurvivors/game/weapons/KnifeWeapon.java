package com.smurfsurvivors.game.weapons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class KnifeWeapon extends PassiveWeapon{

    float velocity;
    public KnifeWeapon(Vector2 _position){
        super(_position, new Texture("Weapons/Knife.png"), 50,50, 500f, 10, "Knife");
        velocity = 20f;

    }

    public void update(){
        positionRectangle.x += velocity;
    }

    public void render(SpriteBatch batch){
        batch.draw(weaponTexture, positionRectangle.x, positionRectangle.y, 50, 50);
    }

}
