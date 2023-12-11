package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Demon;
import com.smurfsurvivors.game.model.entity.Entity;
import com.smurfsurvivors.game.model.weapons.KnifeWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testGetXAndSetX() {
        Vector2 initialPosition = new Vector2(0, 0);
        TextureRegion weaponTexture = new TextureRegion();
        KnifeWeapon testWeapon = new KnifeWeapon(initialPosition, weaponTexture, 2, 20, 30, 2, 100);

        float xValue = 10.0f;
        testWeapon.setX(xValue);
        assertEquals(xValue, testWeapon.getX(), 0.001);
    }

    @Test
    public void testGetYAndSetY() {
        Vector2 initialPosition = new Vector2(0, 0);
        TextureRegion weaponTexture = new TextureRegion();
        KnifeWeapon testWeapon = new KnifeWeapon(initialPosition, weaponTexture, 2, 20, 30, 2, 100);

        float yValue = 20.0f;
        testWeapon.setY(yValue);
        assertEquals(yValue, testWeapon.getY(), 0.001);
    }

    @Test
    public void testGetWidthAndSetWidth() {
        Vector2 initialPosition = new Vector2(0, 0);
        TextureRegion weaponTexture = new TextureRegion();
        KnifeWeapon testWeapon = new KnifeWeapon(initialPosition, weaponTexture, 2, 20, 30, 2, 100);

        float widthValue = 30.0f;
        testWeapon.setWidth(widthValue);
        assertEquals(widthValue, testWeapon.getWidth(), 0.001);
    }

    // Repeat similar tests for getHeight, getAttackRange, setAttackRange, getAttackDamage, setAttackDamage, etc.

    @Test
    public void testAddHitEntityAndGetHitEntities() {
        Vector2 initialPosition = new Vector2(0, 0);
        TextureRegion weaponTexture = new TextureRegion();
        KnifeWeapon testWeapon = new KnifeWeapon(initialPosition, weaponTexture, 2, 20, 30, 2, 100);

        Demon demon = new Demon(100, 100); // You may need to create a mock or a real Entity object
        testWeapon.addHitEntity(demon);
        assertTrue(testWeapon.getHitEntities().contains(demon));
    }
}
