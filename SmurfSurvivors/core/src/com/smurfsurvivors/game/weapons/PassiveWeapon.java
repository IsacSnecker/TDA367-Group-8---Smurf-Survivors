package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public abstract class PassiveWeapon extends AbstractWeapon{
    public PassiveWeapon(Vector2 _position, Texture _weaponTexture, float _width, float _height, float _attackRange, int _velocity, int _attackDamage, String _weaponName){
        super(_position, _weaponTexture, _width, _height, _attackRange, _velocity, _attackDamage, _weaponName);
    }
}
