package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class BulletHandler extends AbstractWeaponHandler implements IHandler{
    public BulletHandler(WeaponInformationHandler weaponInformationHandler){
        super(200f, weaponInformationHandler);
    }

    public static TextureRegion weaponTexture = new TextureRegion(new Texture("Weapons/bullet.png"));

    @Override
    public void spawnProjectile(Vector2 position) {
        if(getLevel() == 1){
            addWeapon(position, 20, 30, 0);
            cooldown = 200f;
        } else if (getLevel() == 2){
            addWeapon(position,20, 40, 0);
            cooldown = 150f;
        } else if (getLevel() == 3){
            addWeapon(position,20, 40, 0);
            cooldown = 100f;
        } else if (getLevel() == 4){
            addWeapon(position,20, 40, 0);
            cooldown = 50f;
        } else if (getLevel() == 5){
            cooldown = 50f;
            addWeapon(position,30, 50, 0);
            addWeapon(position,30, 50, 0);
        }
    }

    public void updateProjectile(AbstractWeapon Weapon){
        Weapon.update();
    }

    public void addWeapon(Vector2 position, int velocity, int attackDamage, int passThrough){
        WeaponList.add(new BulletWeapon(position, weaponTexture, velocity, attackDamage, passThrough, weaponInformationHandler.getPlayerDirection()));
    }

}
