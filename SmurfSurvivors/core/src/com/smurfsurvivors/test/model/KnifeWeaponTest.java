package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.KnifeWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnifeWeaponTest extends LibGDXTest{
    @Test
    void update() {
        KnifeWeapon knife = new KnifeWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 0, 1);
        knife.update();
        assertEquals(2, knife.getY());
        assertEquals(0, knife.getX());

        knife = new KnifeWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 1, 1);
        knife.update();
        assertEquals(2, knife.getY());
        assertEquals(2, knife.getX());

        knife = new KnifeWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 2, 1);
        knife.update();
        assertEquals(0, knife.getY());
        assertEquals(2, knife.getX());

        knife = new KnifeWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 3, 1);
        knife.update();
        assertEquals(-2, knife.getY());
        assertEquals(2, knife.getX());

        knife = new KnifeWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 4, 1);
        knife.update();
        assertEquals(-2, knife.getY());
        assertEquals(0, knife.getX());

        knife = new KnifeWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 5, 1);
        knife.update();
        assertEquals(-2, knife.getY());
        assertEquals(-2, knife.getX());

        knife = new KnifeWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 6, 1);
        knife.update();
        assertEquals(0, knife.getY());
        assertEquals(-2, knife.getX());

        knife = new KnifeWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 7, 1);
        knife.update();
        assertEquals(2, knife.getY());
        assertEquals(-2, knife.getX());
    }
}
