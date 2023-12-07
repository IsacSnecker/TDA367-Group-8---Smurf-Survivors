package com.smurfsurvivors.game.model.weapons.projectiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MagicWeapon extends AbstractWeapon {
    private final Vector2 nearestEnemyPosition;

    public MagicWeapon(Vector2 _position, TextureRegion weaponTexture, int velocity, int attackDamage, int passThrough, Vector2 nearestEnemyPosition) {
        super(_position, weaponTexture, 50f, 50f, 5000f, "Magic");
        this.velocity = velocity;
        this.attackDamage = attackDamage;
        this.passThrough = passThrough;
        this.nearestEnemyPosition = nearestEnemyPosition;

    }

    @Override
    public void update(){
        moveTowardsPosition(nearestEnemyPosition);
    }

    public Vector2 getEnemyPosition(){
        return nearestEnemyPosition;
    }

    @Override
    public void render(SpriteBatch batch){
        batch.draw(weaponTexture, position.x, position.y, width, height, width, height, 1,1, calculateRotation() - 90);
    }

    private float calculateRotation(){
        return (float) Math.toDegrees(Math.atan2(nearestEnemyPosition.y - position.y, nearestEnemyPosition.x - position.x));
    }
}
