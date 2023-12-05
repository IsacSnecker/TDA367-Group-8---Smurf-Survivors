package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.model.factories.EntityFactory;
import com.smurfsurvivors.game.model.entity.Food;

import java.util.ArrayList;
import java.util.Random;

public class FoodHandler  {

    private int maxFoodCount;
    private int foodCount;

    private ArrayList<Food> foodList = new ArrayList<>();

    public FoodHandler(int maxFoodCount) {
        this.maxFoodCount = maxFoodCount;
        this.foodCount = 0;
    }


    public void update() {
        updateFood();
    }

    public void removeFood(Food food) {
        foodList.remove(food);
    }

    private void addFood(Food food) {
        foodList.add(food);
    }

    public ArrayList<Food> getFoods() {
        return this.foodList;
    }

    private void updateFood() {

        Random random = new Random();

        while (foodCount < maxFoodCount) {

            int x = random.nextInt(0,32000);
            int y = random.nextInt(0,32000);


            Food food = EntityFactory.createFood((int) x, (int) y);
            addFood(food);
            foodCount++;


        }

    }



}
