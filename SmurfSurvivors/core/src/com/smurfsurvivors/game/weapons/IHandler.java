package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.entity.Entity;

import java.util.ArrayList;

public interface IHandler {

    void spawnProjectile(Vector2 position);
    ArrayList<AbstractWeapon> getProjectiles();
    void updateProjectiles(Vector2 position, long time, Vector2 enemyPosition);
    void renderProjectiles(SpriteBatch batch);
    void removeProjectile(AbstractWeapon projectile);

    void updateWeaponCooldown();
}