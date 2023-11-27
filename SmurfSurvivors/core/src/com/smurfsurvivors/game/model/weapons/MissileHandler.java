package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Enemy;

public class MissileHandler extends AbstractWeaponHandler implements IHandler{
    public MissileHandler(WeaponInformationHandler weaponInformationHandler){
        super(1000f, weaponInformationHandler);
    }

    public static Texture weaponTexture = new Texture("Weapons/missile.png");

    @Override
    public void spawnProjectile(Vector2 position) {
        WeaponList.add(new MissileWeapon(position, weaponTexture, weaponInformationHandler.getNearestEnemy()));
    }


    public void updateProjectile(AbstractWeapon Weapon){
        Weapon.update();
        if(Weapon instanceof MagicWeapon){
            if(Weapon.position.dst2(((MissileWeapon) Weapon).getEnemy().getPosition()) < Weapon.velocity + 50){
                weaponsToRemove.add(Weapon);
            }
        }
    }
}
