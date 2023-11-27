package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class NukeWeapon {

    Vector2 position;
    Vector2 originalPosition;
    Texture weaponTexture;
    int attackRange;
    float velocity;
    int attackDamage;
    float attackCooldown;
    String weaponName;
    boolean isUseable; //true if cooldown has passed, false otherwise
    public NukeWeapon(Vector2 _position){
        position = _position;
        originalPosition = _position;
        weaponTexture = new Texture("Weapons/knife.png");
        attackRange = 500;
        velocity = 0;
        attackDamage = 1000;
        attackCooldown = 100;
        weaponName = "Nuke";
        isUseable = true;

    }

    public void update(){

    }
}
