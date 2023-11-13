package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class ActiveWeapon extends AbstractWeapon{
    public ActiveWeapon(Vector2 _position, Texture _weaponTexture, float _width, float _height, float _attackRange, int _attackDamage, String _weaponName){
        super(_position, _weaponTexture, _width, _height,  _attackRange, _attackDamage, _weaponName);
    }
}
