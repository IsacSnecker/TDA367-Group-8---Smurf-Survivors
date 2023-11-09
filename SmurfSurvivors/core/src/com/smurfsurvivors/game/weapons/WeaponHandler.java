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
    public interface List<E> extends Collection<E>{};
    KnifeHandler knifeHandler;

    public WeaponHandler(SpriteBatch _batch){
        batch = _batch;
        knifeHandler = new KnifeHandler(batch);
    }

    public void passiveWeaponUpdate(Vector2 position){
        long elapsedTime = TimeUtils.timeSinceMillis(startTime);
        knifeHandler.update(position, elapsedTime);
    }

}
