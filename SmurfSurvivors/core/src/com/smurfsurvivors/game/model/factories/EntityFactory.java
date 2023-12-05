package com.smurfsurvivors.game.model.factories;

import com.smurfsurvivors.game.model.entity.Food;

public abstract  class EntityFactory {

    public static Food createFood(int x, int y) {
        return new Food(20, x, y, 32, 32);
    }

}
