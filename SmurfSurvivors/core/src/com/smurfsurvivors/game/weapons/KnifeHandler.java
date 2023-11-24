package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class KnifeHandler extends AbstractWeaponHandler implements IHandler{

    public KnifeHandler(WeaponInformationHandler weaponInformationHandler){
        super(500f, weaponInformationHandler);
    }

    public static Texture weaponTexture = new Texture("Weapons/knife.png");

    @Override
    public void spawnProjectile(Vector2 position) {
        WeaponList.add(new KnifeWeapon(position, weaponTexture, weaponInformationHandler.getPlayerDirection()));
    }

    public void updateProjectile(AbstractWeapon Weapon){
        Weapon.update();
    }
}

