package com.smurfsurvivors.test.model;

import com.smurfsurvivors.game.model.Difficulty;
import com.smurfsurvivors.game.model.entity.Demon;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.factories.DifficultyFactory;
import com.smurfsurvivors.game.model.factories.EnemyFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DifficultyFactoryTest extends LibGDXTest {
    @Test
    void createEasyDifficulty(){
        Difficulty difficulty = DifficultyFactory.createEasyDifficulty();
        assertEquals(0.05, difficulty.getSpawnRateAdd());
        assertEquals(1, difficulty.getEnemyHealthMultiplier());
        assertEquals(1, difficulty.getEnemySpeedMultiplier());
    }

    @Test
    void createNormalDifficulty(){
        Difficulty difficulty = DifficultyFactory.createNormalDifficulty();
        assertEquals(0.1, difficulty.getSpawnRateAdd());
        assertEquals(2, difficulty.getEnemyHealthMultiplier());
        assertEquals(2, difficulty.getEnemySpeedMultiplier());
    }
    @Test
    void createHardDifficulty(){
        Difficulty difficulty = DifficultyFactory.createHardDifficulty();
        assertEquals(0.3, difficulty.getSpawnRateAdd());
        assertEquals(3, difficulty.getEnemyHealthMultiplier());
        assertEquals(3, difficulty.getEnemySpeedMultiplier());
    }

}