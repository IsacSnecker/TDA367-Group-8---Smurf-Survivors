package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractWeapon {

    public Rectangle positionRectangle;
    Vector2 originalPosition;
    public Texture weaponTexture;
    int width;
    int height;
    float attackRange;
    public int attackDamage;
    String weaponName;
    boolean removeMe = false;

    public AbstractWeapon(Vector2 _position, Texture _weaponTexture, int width, int height, float _attackRange, int _attackDamage, String _weaponName){
        positionRectangle = new Rectangle(_position.x, _position.y, width, height);
        originalPosition = new Vector2(_position.x, _position.y);
        weaponTexture = _weaponTexture;
        attackRange = _attackRange;
        attackDamage = _attackDamage;
        weaponName = _weaponName;
    }

    abstract void update();
    public abstract void render(SpriteBatch batch);
    public void performAttack() {
    }
}
