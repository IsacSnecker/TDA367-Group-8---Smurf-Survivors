package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

abstract class AbstractWeaponHandler implements IHandler{

    public interface List<E> extends Collection<E> {};
    ArrayList<AbstractWeapon> WeaponList = new ArrayList<AbstractWeapon> ();
    float cooldown;
    boolean useable;
    long oldTime;
    WeaponInformationHandler weaponInformationHandler;
    public ArrayList<AbstractWeapon> weaponsToRemove = new ArrayList<AbstractWeapon>();

    public AbstractWeaponHandler(float _cooldown, WeaponInformationHandler weaponInformationHandler){
        cooldown = _cooldown;
        useable = true;
        oldTime = 0;
        this.weaponInformationHandler = weaponInformationHandler;
    }

    public void updateProjectiles(Vector2 position, long currentTime){
        for(AbstractWeapon Weapon : WeaponList){
            if(calculateDistance(new Vector2(Weapon.position.x, Weapon.position.y), Weapon.originalPosition) > Weapon.attackRange){
                weaponsToRemove.add(Weapon);
            }
            updateProjectile(Weapon);
        }
        WeaponList.removeAll(weaponsToRemove);
        weaponsToRemove.clear();
        if(useable){
            spawnProjectile(position);
            useable = false;
            oldTime = currentTime;
        } else if ((currentTime - oldTime) > cooldown) {
            useable = true;
        }
    }

    public abstract void updateProjectile(AbstractWeapon Weapon);

    public void renderProjectiles(SpriteBatch batch){
        for(AbstractWeapon Weapon : WeaponList){
            Weapon.render(batch);
        }
    }

    public void removeProjectile(AbstractWeapon projectile){
        WeaponList.remove(projectile);
    }

    public ArrayList<AbstractWeapon> getProjectiles(){
        return WeaponList;
    }

    public abstract void spawnProjectile(Vector2 position);

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }

    public void updateWeaponCooldown() {
        cooldown = cooldown - (5f * Gdx.graphics.getDeltaTime());
    }
}
