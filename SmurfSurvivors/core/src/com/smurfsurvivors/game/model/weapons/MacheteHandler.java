package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MacheteHandler extends AbstractWeaponHandler implements IHandler{

    public MacheteHandler(WeaponInformationHandler weaponInformationHandler){
        super(200f, weaponInformationHandler);
    }

    public static TextureRegion weaponTexture = new TextureRegion(new Texture("Weapons/machete.png"));

    @Override
    public void spawnProjectile(Vector2 position) {
    if(getLevel() == 1){
        addWeapon(position, 10, 30, 0);
        cooldown = 5000f;
    } else if (getLevel() == 2){
        addWeapon(position,12, 40, 0);
        cooldown = 4000f;
    } else if (getLevel() == 3){
        addWeapon(position,14, 40, 0);
        cooldown = 3000f;
    } else if (getLevel() == 4){
        addWeapon(position,16, 50, 1);
        cooldown = 3000f;
    } else if (getLevel() == 5){
        cooldown = 500f;
        addWeapon(position,20, 100, 10);
    }
}

    public void updateProjectile(AbstractWeapon Weapon){
    Weapon.update();
}

    private void addWeapon(Vector2 position, int velocity, int attackDamage, int passThrough){
        for(int i = 0; i <= 7; i++){
            WeaponList.add(new MacheteWeapon(position, weaponTexture, velocity, attackDamage, passThrough, i));
        }
    }
}
