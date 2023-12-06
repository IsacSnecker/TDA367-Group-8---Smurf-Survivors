package com.smurfsurvivors.test.model;

import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Demon;
import com.smurfsurvivors.game.model.entity.Creature;
import com.smurfsurvivors.test.model.LibGDXTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CreatureTest extends LibGDXTest {

    @Test
    public void testAddHealth() {
        Creature creature = new Demon(100, 100);
        creature.decreaseHealth(30);
        creature.addHealth(20);

        assertEquals(90, creature.getHealth());
    }

    @Test
    public void testAddHealthPastCap() {
        Creature creature = new Demon(100, 100);
        creature.addHealth(20);

        assertEquals(100, creature.getHealth());
    }

    @Test
    public void testAddHealthWithOverflow() {
        Creature creature = new Demon(100, 100);
        creature.addHealth(20);

        assertEquals(100, creature.getHealth());
    }

    @Test
    public void testDecreaseHealth() {
        Creature creature = new Demon(100, 100);
        creature.decreaseHealth(20);

        assertEquals(80, creature.getHealth());
        assertTrue(creature.getIsHurt());
    }

    //TODO
    /*
    @Test
    public void testGetDirection() {
        Creature creature = new Demon(100, 100);
        creature.move()
        assertEquals(3, creature.getDirection());
    }*/

    @Test
    public void testSetDirection() {
        Creature creature = new Demon(100, 100);
        creature.setDirection(4);

        assertEquals(4, creature.getDirection());
    }

    @Test
    public void testMove() {
        Creature creature = new Demon(100, 100);
        creature.move(2.0f, 3.0f);

        assertEquals(102.0f, creature.getX(), 0.001);
        assertEquals(103.0f, creature.getY(), 0.001);
    }

    @Test
    public void testSetHurt() {
        Creature creature = new Demon(100, 100);
        creature.setHurt(true);

        assertTrue(creature.getIsHurt());
    }
}