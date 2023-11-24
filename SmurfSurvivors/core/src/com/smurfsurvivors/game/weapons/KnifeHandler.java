package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class KnifeHandler extends AbstractWeaponHandler implements IHandler{

    public KnifeHandler(){
        super(500f);
    }

    public static Texture weaponTexture = new Texture("Weapons/knife.png");

    @Override
    public void spawnProjectile(Vector2 position) {
        WeaponList.add(new KnifeWeapon(position, weaponTexture));
    }
}

