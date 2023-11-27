package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

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
    }
}
