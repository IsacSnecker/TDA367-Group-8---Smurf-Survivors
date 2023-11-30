package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class PassiveWeapon extends AbstractWeapon{
    public PassiveWeapon(Vector2 _position, TextureRegion _weaponTexture, float _width, float _height, float _attackRange, String _weaponName){
        super(_position, _weaponTexture, _width, _height, _attackRange, _weaponName);
    }
}
