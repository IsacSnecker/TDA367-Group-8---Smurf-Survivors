package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.KnifeWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AbstractWeaponTest extends LibGDXTest{
    @Test
    public void testGetPositionRectangle() {
        Vector2 initialPosition = new Vector2(0, 0);
        TextureRegion weaponTexture = new TextureRegion();
        KnifeWeapon testWeapon = new KnifeWeapon(initialPosition, weaponTexture, 10, 20, 30, 2, 100);

        Rectangle positionRectangle = testWeapon.getPositionRectangle();
        assertNotNull(positionRectangle);
        assertEquals(testWeapon.getX(), positionRectangle.getX(), 0.01);
        assertEquals(testWeapon.getY(), positionRectangle.getY(), 0.01);
        assertEquals(testWeapon.getWidth(), positionRectangle.getWidth(), 0.01);
        assertEquals(testWeapon.getHeight(), positionRectangle.getHeight(), 0.01);
    }

    @Test
    public void testMoveTowardsPosition() {
        Vector2 initialPosition = new Vector2(0, 0);
        TextureRegion weaponTexture = new TextureRegion();
        KnifeWeapon testWeapon = new KnifeWeapon(initialPosition, weaponTexture, 2, 20, 30, 2, 100);

        Vector2 newPosition = new Vector2(2, 2);
        testWeapon.moveTowardsPosition(newPosition);
        assertEquals(1.41, testWeapon.getX(), 0.01);
        assertEquals(1.41, testWeapon.getY(), 0.01);
    }

    @Test
    public void testMove() {
        Vector2 initialPosition = new Vector2(0, 0);
        TextureRegion weaponTexture = new TextureRegion();
        KnifeWeapon testWeapon = new KnifeWeapon(initialPosition, weaponTexture, 2, 20, 30, 2, 100);

        float initialX = testWeapon.getX();
        float initialY = testWeapon.getY();
        testWeapon.move(5, 10);
        assertEquals(initialX + 5, testWeapon.getX(), 0.01);
        assertEquals(initialY + 10, testWeapon.getY(), 0.01);
    }
}
