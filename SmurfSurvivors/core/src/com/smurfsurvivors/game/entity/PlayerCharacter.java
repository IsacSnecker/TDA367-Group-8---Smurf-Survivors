package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.weapons.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerCharacter extends Creature{ //Should PlayerCharacter be used through delegation?

    private int xp;
    private int level;
    private Texture spriteRight;
    private Texture spriteLeft;
    private int maxHealth;
    private List<PassiveWeapon> passiveWeapons; //Should be List<PassiveWeapon>
    private List<ActiveWeapon> abilities; //Should be List<Ability>

    public WeaponHandler WHandler = new WeaponHandler();

    public PlayerCharacter(int health, Texture sprite, int x, int y, int width, int height, int speed) {
        super(health, sprite, x, y, width, height, speed);
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
        if (inputList.get(0) == 1 && inputList.get(1) != 1){
            this.setY(this.getY() + 10);
        }
        if (inputList.get(1) == 1 && inputList.get(0) != 1){
            this.setY(this.getY() - 10);
        }
        if (inputList.get(2) == 1 && inputList.get(3) != 1){
            this.setX(this.getX() + 10);
            this.setTexture(this.spriteRight);
        }
        if (inputList.get(3) == 1 && inputList.get(2) != 1){
            this.setX(this.getX() - 10);
            this.setTexture(this.spriteLeft);
        }
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