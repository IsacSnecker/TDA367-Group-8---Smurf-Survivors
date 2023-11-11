package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Collection;

public class WeaponHandler {
    long startTime;
    public interface List<E> extends Collection<E>{};

    ArrayList<IHandler> handlerList = new ArrayList<IHandler>();

    public WeaponHandler(){
        startTime = TimeUtils.millis();
    }

    public void giveKnife(){
        handlerList.add(new KnifeHandler());
    }

    public void passiveWeaponUpdate(Vector2 position){
        long elapsedTime = TimeUtils.timeSinceMillis(startTime);
        for(IHandler handler : handlerList){
            handler.updateProjectiles(position, elapsedTime);
        }
    }

    public ArrayList<AbstractWeapon> getProjectiles(){
        ArrayList<AbstractWeapon> returnList = new ArrayList<AbstractWeapon>();
        for(IHandler handler : handlerList){
            for(AbstractWeapon projectile : handler.getProjectiles())
                returnList.add(projectile);
        }
        return returnList;
    }

    public ArrayList<IHandler> getWeaponHandlers(){
        ArrayList<IHandler> returnList = new ArrayList<IHandler>();
        for(IHandler handler : handlerList){
            returnList.add(handler);
        }
        return returnList;
    }

}
