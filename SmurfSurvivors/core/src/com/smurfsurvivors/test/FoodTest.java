package com.smurfsurvivors.test;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.model.entity.Food;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest extends LibGDXTest {

    @Test
    void getHealth() {
        PlayerCharacter player = new PlayerCharacter(100, new Texture("Player/smurf-100x100.png"), 0,0,100,100, 10, 0);
        Food food = new Food(200, 0, 0, 10, 10);

    }
}