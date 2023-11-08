package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import jdk.internal.vm.vector.VectorSupport;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class WeaponHandler {

    SpriteBatch batch;
    long startTime = TimeUtils.millis();
    long elapsedTime = TimeUtils.timeSinceMillis(startTime);
    public interface List<E> extends Collection<E>{};
    ArrayList<PassiveWeapon> passiveWeaponList = new ArrayList<PassiveWeapon> ();
    ArrayList<ActiveWeapon> activeWeaponList = new ArrayList<ActiveWeapon> ();

    public void WeaponHandler(SpriteBatch _batch){
        batch = _batch;
    }

    KnifeHandler knifeHandler = new KnifeHandler();

    public void passiveWeaponUpdate(Vector2 position){
        knifeHandler.update(position, elapsedTime);
    }

}
