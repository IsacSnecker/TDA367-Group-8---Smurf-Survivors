package com.smurfsurvivors.test.model;

import com.smurfsurvivors.game.model.entity.Food;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import org.junit.jupiter.api.Test;

class FoodTest extends LibGDXTest {

    @Test
    void getHealth() {
        PlayerCharacter player = new PlayerCharacter(100, 0,0,100,100, 10, 0);
        Food food = new Food(200, 0, 0, 10, 10);

    }
}