package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;

public class AbstractWeapon {

    private Texture sprite;
    private int range;
    private int damage;
    private float cooldown;
    private String name;

    public Texture getSprite() {
        return sprite;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public float getCooldown() {
        return cooldown;
    }

    public String getName() {
        return name;
    }



}
