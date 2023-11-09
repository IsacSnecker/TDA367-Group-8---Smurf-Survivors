package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import static java.lang.Math.*;

public class KnifeWeapon extends PassiveWeapon{

    Vector2 position;
    Vector2 originalPosition;
    Texture weaponTexture;
    float attackRange;
    float velocity;
    int attackDamage;
    float attackCooldown;
    String weaponName;
    boolean isUseable; //true if cooldown has passed, false otherwise
    public KnifeWeapon(Vector2 _position){
        position = _position;
        originalPosition = new Vector2(_position.x,position.y);
        weaponTexture = new Texture("Weapons/knife.png");
        attackRange = 1000f;
        velocity = 20f;
        attackDamage = 10;
        attackCooldown = 0.8f;
        weaponName = "Knife";
        isUseable = true;

    }

    public void update(){
        if(calculateDistance(position, originalPosition) < attackRange){
            position.x += velocity;
        } else {
            isUseable = false;
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(weaponTexture, position.x, position.y, 100, 100);
    }

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }

}
