package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class KnifeHandler extends AbstractWeaponHandler implements IHandler{

    public KnifeHandler(WeaponInformationHandler weaponInformationHandler){
        super(500f, weaponInformationHandler);
    }

    public static TextureRegion weaponTexture = new TextureRegion(new Texture("Weapons/knife.png"));

    @Override
    public void spawnProjectile(Vector2 position) {
        if(getLevel() == 1){
            addWeapon(position, 20, 50, 0);
            cooldown = 500f;
        } else if (getLevel() == 2){
            addWeapon(position,20, 70, 1);
            cooldown = 400f;
        } else if (getLevel() == 3){
            addWeapon(position,20, 70, 1);
            cooldown = 300f;
        } else if (getLevel() == 4){
            addWeapon(position,20, 70, 1);
            cooldown = 100f;
        } else if (getLevel() == 5){
            cooldown = 25f;
            addWeapon(position,30, 100, 5);
        }
    }

    public void updateProjectile(AbstractWeapon Weapon){
        Weapon.update();
    }

    private void addWeapon(Vector2 position, int velocity, int attackDamage, int passThrough){
        WeaponList.add(new KnifeWeapon(position, weaponTexture, velocity, attackDamage, passThrough, weaponInformationHandler.getPlayerDirection()));
    }
}

