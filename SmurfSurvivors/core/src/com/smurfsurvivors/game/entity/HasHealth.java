package com.smurfsurvivors.game.entity;

public interface HasHealth {
    int getHealth();
    void decreaseHealth(int amount);
    //void increaseHealth(int amount);
}
