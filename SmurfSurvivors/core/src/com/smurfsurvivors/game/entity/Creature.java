package com.smurfsurvivors.game.entity;

public abstract class Creature extends Entity{
    private int health;

    public abstract int getHealth();
    public abstract void decreaseHealth();


}
