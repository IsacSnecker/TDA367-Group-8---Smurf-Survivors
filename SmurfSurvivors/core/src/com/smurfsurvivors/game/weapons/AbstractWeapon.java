package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract class AbstractWeapon {
    Texture weaponTexture;
    int attackRange;
    int attackDamage;
    int attackCooldown;
    String weaponName;
    boolean isUseable; //true if cooldown has passed, false otherwise

    abstract void update();
    abstract void render(SpriteBatch batch);
}
