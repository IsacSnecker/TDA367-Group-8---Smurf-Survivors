package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MissileHandler extends AbstractWeaponHandler implements IHandler{
    public MissileHandler(WeaponInformationHandler weaponInformationHandler){
        super(1000f, weaponInformationHandler);
    }

    public static TextureRegion weaponTexture = new TextureRegion(new Texture("Weapons/missile.png"));

    @Override
    public void spawnProjectile(Vector2 position) {
        WeaponList.add(new MissileWeapon(position, weaponTexture, weaponInformationHandler.getNearestEnemy()));
    }

    public void updateProjectile(AbstractWeapon Weapon){
        Weapon.update();
        if(((MissileWeapon) Weapon).getEnemy().getIsDead()){
            weaponsToRemove.add(Weapon);
        }
    }
}
