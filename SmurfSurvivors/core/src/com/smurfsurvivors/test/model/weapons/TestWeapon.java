package com.smurfsurvivors.test.model.weapons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.AbstractWeapon;

class TestWeapon extends AbstractWeapon {
    public TestWeapon(Vector2 _position, TextureRegion _weaponTexture, float _width, float _height, float _attackRange, String _weaponName) {
        super(_position, _weaponTexture, _width, _height, _attackRange, _weaponName);
    }

    @Override
    public void update() {
        // Implement this method for testing purposes
    }
}
