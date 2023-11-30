package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.*;

public class WeaponHandler {
    long startTime;
    int playerDirection = 1;
    private Map<String, IHandler> handlerMap = new HashMap<String, IHandler>();
    ArrayList<IHandler> handlerList = new ArrayList<IHandler>();
    public WeaponInformationHandler weaponInformationHandler;

    public WeaponHandler(){
        startTime = TimeUtils.millis();
        weaponInformationHandler = new WeaponInformationHandler();
    }

    public void addWeaponHandler(IHandler handler){
        handlerList.add(handler);
    }
    public void addBulletHandler(){
        handlerList.add(new BulletHandler(weaponInformationHandler));
        handlerMap.put("Bullet", new BulletHandler(weaponInformationHandler));
    }
    public void addKnifeHandler(){
        handlerList.add(new KnifeHandler(weaponInformationHandler));
        handlerMap.put("Knife", new KnifeHandler(weaponInformationHandler));
    }
    public void addMagicHandler(){
        handlerList.add(new MagicHandler(weaponInformationHandler));
        handlerMap.put("Magic", new MagicHandler(weaponInformationHandler));
    }
    public void addMissileHandler(){
        handlerList.add(new MissileHandler(weaponInformationHandler));
        handlerMap.put("Missile", new MissileHandler(weaponInformationHandler));
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

    public void removeProjectile(AbstractWeapon projectile){
        for(IHandler handler :handlerList){
            if(handler.getProjectiles().contains(projectile)){
                handler.removeProjectile(projectile);
            }
        }
    }

    public void updateWeaponCooldowns(){
    }

    public void updatePlayerDirection(int direction) {
        playerDirection = direction;
    }

    public void levelUpBullet(){
        handlerMap.get("Bullet").levelUp();
    }
    public void levelUpKnife(){
        handlerMap.get("Knife").levelUp();
    }
    public void levelUpMissile(){
        handlerMap.get("Missile").levelUp();
    }
    public void levelUpMagic(){
        handlerMap.get("Magic").levelUp();
    }


}
