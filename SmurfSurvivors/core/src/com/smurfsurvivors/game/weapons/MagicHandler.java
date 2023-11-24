package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MagicHandler extends AbstractWeaponHandler implements IHandler{
    public MagicHandler(WeaponInformationHandler weaponInformationHandler){
        super(1000f, weaponInformationHandler);
    }

    public static Texture weaponTexture = new Texture("Weapons/magicprojectile.png");

    @Override
    public void spawnProjectile(Vector2 position) {
        WeaponList.add(new MagicWeapon(position, weaponTexture, weaponInformationHandler.getEnemyPosition()));
    }

    public void updateProjectile(AbstractWeapon Weapon){
        Weapon.update();
        if(Weapon instanceof MagicWeapon){
            if(Weapon.position.dst2(((MagicWeapon) Weapon).getEnemyPosition()) < Weapon.velocity + 50){
                weaponsToRemove.add(Weapon);
            }
        }
    }
}
