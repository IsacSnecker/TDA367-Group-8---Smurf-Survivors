package com.smurfsurvivors.game.model.entity;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.model.weapons.*;
import com.smurfsurvivors.game.model.weapons.*;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class PlayerCharacter extends Creature{ //Should PlayerCharacter be used through delegation?

    private int xp;
    private int level;
    private Texture spriteRight;
    private Texture spriteLeft;
    private List<PassiveWeapon> passiveWeapons; //Should be List<PassiveWeapon>
    private List<ActiveWeapon> abilities; //Should be List<Ability>
    private int levelCap;
    private float levelCapMultiplier;

    public WeaponHandler WHandler = new WeaponHandler();
    public WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();

    public PlayerCharacter(int health, Texture sprite, float x, float y, int width, int height, float speed, int direction) {
        super(health, sprite, x, y, width, height, speed, direction);
        WHandler.addWeaponHandler(new KnifeHandler(weaponInformationHandler));
        this.xp = 0;
        this.level = 1;
        this.levelCap = 100;
        this.levelCapMultiplier = (float) 1.10;
        this.spriteRight = new Texture("Player/smurf-100x100-right.png");
        this.spriteLeft = new Texture("Player/smurf-100x100.png");
    }
    //private

    public void addAbility(ActiveWeapon ability){
        abilities.add(ability);
    }
    public void usePassiveWeapon(){
        WHandler.updatePlayerDirection(getDirection());
        WHandler.passiveWeaponUpdate(getPosition());
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
        float differenceDiagonal;
        if(inputList.get(0) == 1 && inputList.get(1) == 1){
            differenceDiagonal =  calculateSpeedWhenDiagonal();
            move(differenceDiagonal, differenceDiagonal);
            setDirection(1);
            this.setTexture(this.spriteRight);
        }
        else if(inputList.get(0) == 1 && inputList.get(3) == 1){
            differenceDiagonal =  calculateSpeedWhenDiagonal();
            move(-differenceDiagonal, differenceDiagonal);
            setDirection(7);
            this.setTexture(this.spriteLeft);
        }
        else if(inputList.get(2) == 1 && inputList.get(1) == 1){
            differenceDiagonal =  calculateSpeedWhenDiagonal();
            move(differenceDiagonal, -differenceDiagonal);
            setDirection(3);
            this.setTexture(this.spriteRight);
        }
        else if(inputList.get(2) == 1 && inputList.get(3) == 1){
            differenceDiagonal =  calculateSpeedWhenDiagonal();
            move(-differenceDiagonal, -differenceDiagonal);
            setDirection(5);
            this.setTexture(this.spriteLeft);
        }
        else if (inputList.get(1) == 1 && inputList.get(3) != 1){
            move(getSpeed(), 0);
            this.setTexture(this.spriteRight);
            setDirection(2);
        }
        else if (inputList.get(3) == 1 && inputList.get(1) != 1){
            move(-getSpeed(), 0);
            this.setTexture(this.spriteLeft);
            setDirection(6);
        }
        else if (inputList.get(2) == 1 && inputList.get(0) != 1){
            move(0, -getSpeed());
            setDirection(4);
        }
        else if (inputList.get(0) == 1 && inputList.get(2) != 1){
            move(0, getSpeed());
            setDirection(0);
        }
    }

    private float calculateSpeedWhenDiagonal(){
        return (float)sqrt(pow(getSpeed(), 2.0)/2);
    }

    public boolean addXP(int amount) {
        this.xp += amount;
        if (xp >= levelCap){
            xp -= levelCap;
            level += 1;
            levelCap = (int)((float) levelCap * levelCapMultiplier);
            return true;
        }
        return false;
    }

    public int getXP() {
        return this.xp;
    }

    public int getLevel() {
        return this.level;
    }

    public int getLevelCap() {
        return this.levelCap;
    }

    public WeaponInformationHandler getWeaponInformationHandler() { return weaponInformationHandler; }
}