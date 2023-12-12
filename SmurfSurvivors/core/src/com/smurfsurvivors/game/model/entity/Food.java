package com.smurfsurvivors.game.model.entity;

public class Food extends Entity {

    private int health;


    public Food(int health, int x, int y, int width, int height) {
        super("Food", x, y,width, height);
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }


}
