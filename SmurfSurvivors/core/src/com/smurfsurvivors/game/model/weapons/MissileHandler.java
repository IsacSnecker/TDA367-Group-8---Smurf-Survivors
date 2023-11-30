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
        if(getLevel() == 1){
            addWeapon(position, 20, 100, 0);
            cooldown = 200f;
        } else if (getLevel() == 2){
            addWeapon(position,20, 150, 0);
            cooldown = 150f;
        } else if (getLevel() == 3){
            addWeapon(position,20, 200, 0);
            cooldown = 100f;
        } else if (getLevel() == 4){
            addWeapon(position,20, 250, 0);
            cooldown = 50f;
        } else if (getLevel() == 5){
            cooldown = 25f;
            addWeapon(position,30, 300, 0);
            addWeapon(position,30, 300, 0);
        }
    }

    public void updateProjectile(AbstractWeapon Weapon){
        Weapon.update();
        if(((MissileWeapon) Weapon).getEnemy().getIsDead()){
            weaponsToRemove.add(Weapon);
        }
    }

    private void addWeapon(Vector2 position, int velocity, int attackDamage, int passThrough){
        WeaponList.add(new MissileWeapon(position, weaponTexture, velocity, attackDamage, passThrough, weaponInformationHandler.getNearestEnemy()));
    }
}
