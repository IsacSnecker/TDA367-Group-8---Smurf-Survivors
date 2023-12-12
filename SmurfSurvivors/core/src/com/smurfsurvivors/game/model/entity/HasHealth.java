package com.smurfsurvivors.game.model.entity;

public interface HasHealth {
    int getHealth();
    void decreaseHealth(int amount);
}
