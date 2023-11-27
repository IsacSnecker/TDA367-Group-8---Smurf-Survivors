package com.smurfsurvivors.game;

import com.badlogic.gdx.Gdx;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.entity.Food;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import org.lwjgl.Sys;

import java.util.LinkedList;
import java.util.Random;

public class FoodHandler  {

    private int maxFoodCount;
    private int foodCount;

    private GameModel model;

    private LinkedList<Food> foodList = new LinkedList<>();

    public FoodHandler(int maxFoodCount, GameModel model) {
        this.maxFoodCount = maxFoodCount;
        this.foodCount = 0;
        this.model = model;
    }


    public void update() {
        updateFood(model.getPlayer().getX(), model.getPlayer().getY());
    }

    private void removeFood(Food food) {
        foodList.remove(food);
    }

    private void addFood(Food food) {
        foodList.add(food);
    }

    public LinkedList<Food> getFoods() {
        return this.foodList;
    }

    private void updateFood(float playerX, float playerY) {

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
