package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.entity.Entity;

import java.util.ArrayList;

public interface IHandler {
    public ArrayList<AbstractWeapon> getProjectiles();
    public void updateProjectiles(Vector2 position, long time, Entity entity);
    public void renderProjectiles(SpriteBatch batch);
    public void removeProjectile(AbstractWeapon projectile);
}