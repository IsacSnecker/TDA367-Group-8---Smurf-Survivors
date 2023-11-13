package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public interface IHandler {
    public ArrayList<AbstractWeapon> getProjectiles();
    public void updateProjectiles(Vector2 position, long time);
    public void renderProjectiles(SpriteBatch batch);
    public void removeProjectile(AbstractWeapon projectile);
}