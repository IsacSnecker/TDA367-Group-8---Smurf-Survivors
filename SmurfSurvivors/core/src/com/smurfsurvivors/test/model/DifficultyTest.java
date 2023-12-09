package com.smurfsurvivors.test.model;

import com.smurfsurvivors.game.model.Difficulty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifficultyTest extends LibGDXTest {

    @Test
    void getSpawnRateAdd(){
        Difficulty difficulty = new Difficulty(0.05, 1, 2);
        assertEquals(0.05, difficulty.getSpawnRateAdd());
    }

    @Test
    void getenemyHealthMultiplier(){
        Difficulty difficulty = new Difficulty(0.05, 1, 2);
        assertEquals(1, difficulty.getEnemyHealthMultiplier());
    }

    @Test
    void getEnemySpeedMultiplier(){
        Difficulty difficulty = new Difficulty(0.05, 1, 2);
        assertEquals(2, difficulty.getEnemySpeedMultiplier());
    }
}