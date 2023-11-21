package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.weapons.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

public class PlayerCharacter extends Creature{ //Should PlayerCharacter be used through delegation?

    private int xp;
    private int level;
    private Texture spriteRight;
    private Texture spriteLeft;
    private int maxHealth;
    private List<PassiveWeapon> passiveWeapons; //Should be List<PassiveWeapon>
    private List<ActiveWeapon> abilities; //Should be List<Ability>

    public WeaponHandler WHandler = new WeaponHandler();

    public PlayerCharacter(int health, Texture sprite, float x, float y, int width, int height, float speed, int direction) {
        super(health, sprite, x, y, width, height, speed, direction);
        WHandler.addWeaponHandler(new KnifeHandler());
        WHandler.addWeaponHandler(new MissileHandler());
        this.xp = 0;
        this.level = 1;
        this.maxHealth = health;
        this.spriteRight = new Texture("Player/smurf-100x100-right.png");
        this.spriteLeft = new Texture("Player/smurf-100x100.png");
    }
    //private

    public void addPassiveWeapon(PassiveWeapon passiveWeapon){
        passiveWeapons.add(passiveWeapon);
    }
    public void addAbility(ActiveWeapon ability){
        abilities.add(ability);
    }
    public void usePassiveWeapon(Vector2 enemyPosition){
        WHandler.passiveWeaponUpdate(getPosition(), enemyPosition);
    }
    public void useAbility(ActiveWeapon ability){
        ability.performAttack();
    }
    public void useAllAbilities(){
        for(ActiveWeapon ability : abilities){
            useAbility(ability);
        }
    }

    public void updatePosition(ArrayList<Integer> inputList){
        float dx = 0;
        float dy = 0;
        if(inputList.get(0) == 1 && inputList.get(1) == 1){
            dx =  calculateSpeedWhenDiagonal();
            dy =  calculateSpeedWhenDiagonal();
            move(dx, dy);
            setDirection(1);
            this.setTexture(this.spriteRight);

        }
        else if(inputList.get(0) == 1 && inputList.get(3) == 1){
            dx = calculateSpeedWhenDiagonal();
            dy = calculateSpeedWhenDiagonal();
            move(-dx, dy);
            setDirection(7);
            this.setTexture(this.spriteLeft);

        }
        else if(inputList.get(2) == 1 && inputList.get(1) == 1){
            dx = calculateSpeedWhenDiagonal();
            dy = calculateSpeedWhenDiagonal();
            move(dx, -dy);
            setDirection(3);
            this.setTexture(this.spriteRight);

        }
        else if(inputList.get(2) == 1 && inputList.get(3) == 1){
            dx = calculateSpeedWhenDiagonal();
            dy = calculateSpeedWhenDiagonal();
            move(-dx, -dy);
            setDirection(5);
            this.setTexture(this.spriteLeft);

        }
        else if (inputList.get(0) == 1 && inputList.get(2) != 1){
            this.setY(this.getY() + getSpeed());
            setDirection(0);
        }
        else if (inputList.get(1) == 1 && inputList.get(3) != 1){
            this.setX(this.getX() + getSpeed());
            this.setTexture(this.spriteRight);
            setDirection(1);
        }
        else if (inputList.get(2) == 1 && inputList.get(0) != 1){
            this.setY(this.getY() - getSpeed());
            setDirection(2);
        }
        else if (inputList.get(3) == 1 && inputList.get(1) != 1){
            this.setX(this.getX() - getSpeed());
            this.setTexture(this.spriteLeft);
            setDirection(3);
        }
    }

    private float calculateSpeedWhenDiagonal(){
        return (float)sqrt(pow(getSpeed(), 2.0)/2);
    }

    public int getXP() {
        return this.xp;
    }

    public int getLevel() {
        return this.level;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

}