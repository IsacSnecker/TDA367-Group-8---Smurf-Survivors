package com.smurfsurvivors.test.model.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.smurfsurvivors.game.model.entity.Enemy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.smurfsurvivors.game.model.entity.Entity;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractWeaponTest {

    @Test
    void testMove() {
        TestWeapon weapon = new TestWeapon(new Vector2(0, 0), null, 10, 10, 5, "Test");
        weapon.move(5, 5);
        assertEquals(5, weapon.getX());
        assertEquals(5, weapon.getY());
    }
    @Test
    void testMoveTowardsPosition() {
        TestWeapon weapon = new TestWeapon(new Vector2(0, 0), null, 10, 10, 5, "Test");
        weapon.moveTowardsPosition(new Vector2(5, 5));
        assertEquals(5, weapon.getX(), 0.01);
        assertEquals(5, weapon.getY(), 0.01);
    }

    @Test
    void testRender() {
        TestWeapon weapon = new TestWeapon(new Vector2(0, 0), null, 10, 10, 5, "Test");
        SpriteBatch mockBatch = Mockito.mock(SpriteBatch.class);
        weapon.render(mockBatch);
        //Mockito.verify(mockBatch).draw(Mockito.any(), Mockito.eq(0f), Mockito.eq(0f), Mockito.eq(10f), Mockito.eq(10f), Mockito.eq(10f), Mockito.eq(10f), Mockito.eq(1f), Mockito.eq(1f), Mockito.eq(180f));
    }

    @Test
    void testGettersAndSetters() {
        TestWeapon weapon = new TestWeapon(new Vector2(0, 0), null, 10, 10, 5, "Test");
        weapon.setX(5);
        assertEquals(5, weapon.getX());
        weapon.setY(5);
        assertEquals(5, weapon.getY());
        weapon.setWidth(20);
        assertEquals(20, weapon.getWidth());
        weapon.setHeight(20);
        assertEquals(20, weapon.getHeight());
        weapon.setAttackRange(10);
        assertEquals(10, weapon.getAttackRange());
        weapon.setAttackDamage(50);
        assertEquals(50, weapon.getAttackDamage());
        weapon.setWeaponName("TestWeapon");
        assertEquals("TestWeapon", weapon.getWeaponName());
    }

    // Add more tests here for other methods in the AbstractWeapon class
}