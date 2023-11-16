package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.smurfsurvivors.game.entity.Entity;
import sun.security.x509.AVA;

import java.util.ArrayList;
import java.util.Collection;

public class WeaponHandler {
    long startTime;
    public interface List<E> extends Collection<E>{};

    ArrayList<IHandler> handlerList = new ArrayList<IHandler>();

    public WeaponHandler(){
        startTime = TimeUtils.millis();
    }

    public void addWeaponHandler(IHandler handler){
        handlerList.add(handler);
    }

    public void passiveWeaponUpdate(Vector2 position, Vector2 enemyPosition){
        long elapsedTime = TimeUtils.timeSinceMillis(startTime);
        for(IHandler handler : handlerList){
            handler.updateProjectiles(position, elapsedTime, enemyPosition);
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

    public void removeProjectile(AbstractWeapon projectile){
        for(IHandler handler :handlerList){
            if(handler.getProjectiles().contains(projectile)){
                handler.removeProjectile(projectile);
            }
        }
    }

}
