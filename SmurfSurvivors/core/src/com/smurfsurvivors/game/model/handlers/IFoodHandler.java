package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.model.entity.Food;

import java.util.ArrayList;

public interface IFoodHandler {

    void update();

    ArrayList<Food> getFoods();

    void removeFood(Food food);

}
