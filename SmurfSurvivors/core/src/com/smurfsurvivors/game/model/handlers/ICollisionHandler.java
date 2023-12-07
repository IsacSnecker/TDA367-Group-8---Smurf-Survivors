package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.AudioObservable;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.weapons.projectiles.AbstractWeapon;

import java.util.ArrayList;

public interface ICollisionHandler extends AudioObservable {

    void update();
    void handleIfCollision(ArrayList<AbstractWeapon> projectiles, ArrayList<Enemy> enemies);
    void handleIfCollision(ArrayList<Enemy> enemies);
    void handleFoodCollision();

}
