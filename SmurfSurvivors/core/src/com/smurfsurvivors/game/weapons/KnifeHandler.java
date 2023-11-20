package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class KnifeHandler extends AbstractWeaponHandler implements IHandler{

    public KnifeHandler(){
        super(500f);
    }

    @Override
    public void spawnProjectile(Vector2 position) {
        WeaponList.add(new KnifeWeapon(position));
    }
}

