package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.math.Vector2;

public class MissileHandler extends AbstractWeaponHandler implements IHandler{
    public MissileHandler(){
        super(5000f);
    }

    @Override
    public void spawnProjectile(Vector2 position) {
        WeaponList.add(new MissileWeapon(position));
    }
}
