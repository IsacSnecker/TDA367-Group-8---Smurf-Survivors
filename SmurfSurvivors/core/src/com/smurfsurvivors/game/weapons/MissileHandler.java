package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MissileHandler extends AbstractWeaponHandler implements IHandler{
    public MissileHandler(){
        super(1000f);
    }

    public static Texture weaponTexture = new Texture("Weapons/missile.png");

    @Override
    public void spawnProjectile(Vector2 position) {
        WeaponList.add(new MissileWeapon(position, weaponTexture));
    }
}
