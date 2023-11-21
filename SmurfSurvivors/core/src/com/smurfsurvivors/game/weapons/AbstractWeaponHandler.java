package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class AbstractWeaponHandler {

    public interface List<E> extends Collection<E> {};
    ArrayList<AbstractWeapon> WeaponList = new ArrayList<AbstractWeapon> ();
    float cooldown;
    boolean useable;
    long oldTime;

    public AbstractWeaponHandler(float _cooldown){
        cooldown = _cooldown;
        useable = true;
        oldTime = 0;
    }

    public void updateProjectiles(Vector2 position, long currentTime, Vector2 enemyPosition){
        ArrayList<AbstractWeapon> knivesToRemove = new ArrayList<AbstractWeapon>();
        for(AbstractWeapon Weapon : WeaponList){
            if(calculateDistance(new Vector2(Weapon.position.x, Weapon.position.y), Weapon.originalPosition) > Weapon.attackRange){
                knivesToRemove.add(Weapon);
            }
            Weapon.update(enemyPosition);
        }
        WeaponList.removeAll(knivesToRemove);
        knivesToRemove.clear();
        if(useable){
            spawnProjectile(position);
            useable = false;
            oldTime = currentTime;
        } else if ((currentTime - oldTime) > cooldown) {
            useable = true;
        }
    }

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

    public void spawnProjectile(Vector2 position){}

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }
}
