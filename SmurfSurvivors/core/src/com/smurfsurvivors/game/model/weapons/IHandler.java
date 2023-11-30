package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public interface IHandler {

    void spawnProjectile(Vector2 position);
    ArrayList<AbstractWeapon> getProjectiles();
    void updateProjectiles(Vector2 position, long time);
    void renderProjectiles(SpriteBatch batch);
    void removeProjectile(AbstractWeapon projectile);
    void levelUp();
}