package com.smurfsurvivors.test.model;

import com.smurfsurvivors.game.model.entity.Food;
import com.smurfsurvivors.game.model.factories.EntityFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityFactoryTest extends LibGDXTest {

    @Test
    void createFood(){
        Food food = EntityFactory.createFood(100, 120);
        assertEquals(20, food.getHealth());
        assertEquals(100, food.getX());
        assertEquals(120, food.getY());
        assertEquals(32, food.getWidth());
        assertEquals(32, food.getHeight());
    }
}