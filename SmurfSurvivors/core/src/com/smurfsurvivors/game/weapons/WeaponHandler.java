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
    long startTime = TimeUtils.millis();
    public interface List<E> extends Collection<E>{};

    ArrayList<IHandler> handlerList = new ArrayList<IHandler>();

    public WeaponHandler(){}

    public void addWeaponHandler(IHandler handler){
        handlerList.add(handler);
    }

    public void passiveWeaponUpdate(Vector2 position){
        long elapsedTime = TimeUtils.timeSinceMillis(startTime);
        for(IHandler handler : handlerList){
            handler.updateProjectiles(position, elapsedTime);
        }
    }

    public ArrayList getProjectiles(){
        ArrayList<AbstractWeapon> returnList = new ArrayList<AbstractWeapon>();
        for(IHandler handler : handlerList){
            returnList.addAll(handler.getProjectiles());
        }
        return returnList;
    }

}
