package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.BulletWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BulletWeaponTest extends LibGDXTest{

    @Test
    void update(){
        BulletWeapon bullet = new BulletWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 0);
        bullet.update();
        assertEquals(2, bullet.getY());
        assertTrue(5 >= bullet.getX() && bullet.getX() >= -5);

        bullet = new BulletWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 1);
        bullet.update();
        assertTrue(4.5 >= bullet.getY() && bullet.getY() >= -0.5);
        assertTrue(4.5 >= bullet.getX() && bullet.getX() >= -0.5);

        bullet = new BulletWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 2);
        bullet.update();
        assertEquals(2, bullet.getX());
        assertTrue(5 >= bullet.getY() && bullet.getY() >= -5);

        bullet = new BulletWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 3);
        bullet.update();
        assertTrue(0.5 >= bullet.getY() && bullet.getY() >= -4.5);
        assertTrue(4.5 >= bullet.getX() && bullet.getX() >= -0.5);

        bullet = new BulletWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 4);
        bullet.update();
        assertEquals(-2, bullet.getY());
        assertTrue(5 >= bullet.getX() && bullet.getX() >= -5);

        bullet = new BulletWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 5);
        bullet.update();
        assertTrue(0.5 >= bullet.getY() && bullet.getY() >= -4.5);
        assertTrue(0.5 >= bullet.getX() && bullet.getX() >= -4.5);

        bullet = new BulletWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 6);
        bullet.update();
        assertEquals(-2, bullet.getX());
        assertTrue(5 >= bullet.getY() && bullet.getY() >= -5);

        bullet = new BulletWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 7);
        bullet.update();
        assertTrue(4.5 >= bullet.getY() && bullet.getY() >= -0.5);
        assertTrue(0.5 >= bullet.getX() && bullet.getX() >= -4.5);
    }
}
