package com.smurfsurvivors.game;

import com.smurfsurvivors.game.model.entity.Food;

public abstract  class EntityFactory {

    public static Food createFood(int x, int y) {
        return new Food(20, x, y, 10, 10);
    }

}
