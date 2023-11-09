package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Creature extends Entity{
    private int health;



    public int getHealth() {
        return this.health;
    }
    public void decreaseHealth(int val) {
        this.health -= val;
    }


}
