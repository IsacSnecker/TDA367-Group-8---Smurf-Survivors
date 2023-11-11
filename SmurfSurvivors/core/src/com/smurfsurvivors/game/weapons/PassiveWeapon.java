package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public abstract class PassiveWeapon extends AbstractWeapon{
    public PassiveWeapon(Vector2 _position, Texture _weaponTexture, int _width, int _height, float _attackRange, int _attackDamage, String _weaponName){
        super(_position, _weaponTexture, _width, _height, _attackRange, _attackDamage, _weaponName);
    }
}
